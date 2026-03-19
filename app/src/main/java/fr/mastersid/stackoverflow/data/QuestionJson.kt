package fr.mastersid.stackoverflow.data

import com.squareup.moshi.Json

data class QuestionJson(
    @Json(name = "question_id")
    val id: Int,

    val title: String,

    val body: String,

    @Json(name = "answer_count")
    val answerCount: Int
)
