package fr.mastersid.stackoverflow.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mastersid.stackoverflow.data.Question
import fr.mastersid.stackoverflow.repository.QuestionRepository
import fr.mastersid.stackoverflow.data.QuestionResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionListViewModel @Inject constructor(
    private val questionRepository: QuestionRepository
) : ViewModel(){

    //LiveData questions avec pour donn´ee une liste de Question
    private val _questionList: MutableLiveData<List<Question>> = MutableLiveData(emptyList())
    val questionList: LiveData<List<Question>> = _questionList

    //LiveData isUpdating avec pour donnee un booleen
    private val _isUpdating = MutableLiveData(false)
    val isUpdating: LiveData<Boolean> = _isUpdating


    //Liaison ViewModel-Repository : conversion du flux
    //Dans le bloc init{ ... } appel´e par le constructeur de WeatherListViewModel, on fait
    //appel dans une coroutine `a la fonction suspendable collect { ... } du flux
    //weatherResponse
    init {
        viewModelScope.launch(Dispatchers.IO){
            questionRepository.questionResponse.collect{ response ->
                when (response){
                    is QuestionResponse.Pending -> _isUpdating.postValue(true)
                    is QuestionResponse.Success -> {
                        _questionList.postValue(response.list)
                        _isUpdating.postValue(false)
                    }
                }
            }
        }
    }

    //une m´ethode updateQuestions() d´eclench´ee par le bouton de QuestionsScreen
    fun updateQuestionList(){
        viewModelScope.launch(Dispatchers.IO){
            questionRepository.updateQuestionInfo()
        }
    }

}