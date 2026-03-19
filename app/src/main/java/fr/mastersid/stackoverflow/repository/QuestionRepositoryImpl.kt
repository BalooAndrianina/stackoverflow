package fr.mastersid.stackoverflow.repository

import android.util.Log
import fr.mastersid.stackoverflow.webservices.StackOverFlowWebService
import kotlinx.coroutines.flow.MutableSharedFlow
import okio.IOException
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(
    private val stackOverFlowWebService: StackOverFlowWebService
) : QuestionRepository {
    override val questionResponse = MutableSharedFlow<QuestionResponse>()

    override suspend fun updateQuestionInfo(){
        try {
            questionResponse.emit(QuestionResponse.Pending)
            val list = stackOverFlowWebService.getQuestionList(
                order = "desc",
                sort = "activity"
            )
            questionResponse.emit(QuestionResponse.Success(list))
            Log.d("WenService", "List: $list")
//            Log.d("WebService", "Response: $response")
//            Log.d("WebService", "Response body: ${response.body()?.string()}")
        }catch(e: IOException){
            Log.d("WebService", "Exception: $e")
        }
    }
}