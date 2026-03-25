package fr.mastersid.stackoverflow.data

import com.squareup.moshi.Json

data class QuestionJson(

    val question_id: Int,

    val title: String,

    val body: String,

    val answer_count: Int
)
