package fr.mastersid.stackoverflow.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import fr.mastersid.stackoverflow.data.ListQuestionJson
import fr.mastersid.stackoverflow.data.Question
import fr.mastersid.stackoverflow.data.QuestionJson

class QuestionMoshiAdapter {
    @FromJson
    fun fromJson(listQuestionJson: ListQuestionJson): List<Question>{
        return listQuestionJson.items.map{ questionJson ->
            Question(questionJson.question_id, questionJson.title, questionJson.body, questionJson.answer_count)
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