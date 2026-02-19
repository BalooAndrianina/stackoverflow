package fr.mastersid.stackoverflow.repository

import fr.mastersid.stackoverflow.data.Question

//reponses du repository
sealed interface QuestionResponse {
    data object Pending: QuestionResponse //reponse en cours d'élaboration

    @JvmInline
    value class Success(val list: List<Question>): QuestionResponse //reponse valide, avec une liste de question
}