package fr.mastersid.stackoverflow.repository

import android.util.Log
import fr.mastersid.stackoverflow.data.QuestionResponse
import fr.mastersid.stackoverflow.db.QuestionDao
import fr.mastersid.stackoverflow.webservices.StackOverFlowWebService
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import okio.IOException
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(
    private val stackOverFlowWebService: StackOverFlowWebService,
    private val questionDao: QuestionDao
) : QuestionRepository {

    private val pendingFlow : MutableSharedFlow<QuestionResponse> = MutableSharedFlow()
    //On va transformer un flux list<Question> en flux
    override val questionResponse =
        listOf(
            questionDao.getQuestionListFlow().map { list ->
                QuestionResponse.Success(list)
            },
            pendingFlow
        ).merge()

    override suspend fun updateQuestionInfo(){
        pendingFlow.emit(QuestionResponse.Pending)
        try {
            val list = stackOverFlowWebService.getQuestionList(
                order = "desc",
                sort = "activity"
            )
            Log.d("WenService", "List: $list")
            questionDao.insertAll(list)
        }catch(e: IOException){
            Log.d("WebService", "Exception: $e")
        }
    }
}