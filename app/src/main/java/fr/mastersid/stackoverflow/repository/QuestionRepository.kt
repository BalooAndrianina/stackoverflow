package fr.mastersid.stackoverflow.repository

import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    val questionResponse: Flow<QuestionResponse> //déclaration de weatherResponse sous forme de flux
    suspend fun updateWeatherInfo() //fonction suspendable??
}