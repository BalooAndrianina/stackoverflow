package fr.mastersid.stackoverflow.data

import com.squareup.moshi.Json

data class ListQuestionJson(
    @Json(name = "items")
    val list: List<QuestionJson>
)
