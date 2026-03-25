package fr.mastersid.stackoverflow.data

//reponses du repository
sealed interface QuestionResponse {
    data object Pending: QuestionResponse //reponse en cours d'élaboration

    @JvmInline
    value class Success(val list: List<Question>): QuestionResponse //reponse valide, avec une liste de question
}