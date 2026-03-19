package fr.mastersid.stackoverflow.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import fr.mastersid.stackoverflow.data.ListQuestionJson
import fr.mastersid.stackoverflow.data.Question
import fr.mastersid.stackoverflow.data.QuestionJson

class QuestionMoshiAdapter {
    @FromJson
    fun fromJson(listQuestionJson: ListQuestionJson): List<Question>{
        return listQuestionJson.list.map{questionJson ->
            Question(questionJson.id, questionJson.title, questionJson.body, questionJson.answerCount)
        }
    }

    @ToJson
    fun toJson(listQuestion: List<Question>): ListQuestionJson{
        return ListQuestionJson(
            listQuestion.map{ question ->
                QuestionJson(question.id, question.title, question.body, question.answerCount)
            }
        )
    }
}