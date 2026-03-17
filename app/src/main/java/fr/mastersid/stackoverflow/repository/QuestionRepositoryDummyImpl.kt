package fr.mastersid.stackoverflow.repository

import fr.mastersid.stackoverflow.data.Question
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.time.delay
import javax.inject.Inject

// il pourra ˆetre inject´e par Hilt
class QuestionRepositoryDummyImpl @Inject constructor() : QuestionRepository{
    override val questionResponse = MutableSharedFlow <QuestionResponse>()
    val loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"


    override suspend fun updateQuestionInfo() {
        questionResponse.emit(QuestionResponse.Pending)
        delay(3000)
        questionResponse.emit(
            QuestionResponse.Success(
                listOf(
                    Question(1, "Pourquoi ma requête SQL retourne NULL alors que la colonne n’est pas vide ?", loremIpsum, 6),
                    Question(2, "Comment inverser une liste en Python sans utiliser reverse() ?", loremIpsum, 0),
                    Question(3, "Pourquoi mon CSS ne s’applique pas malgré !important ?", loremIpsum, 4),
                    Question(4, "Comment corriger une erreur CORS dans une application React ?", loremIpsum, 6),
                    Question(5, "Quelle est la différence entre == et === en JavaScript ?", loremIpsum, 9),
                    Question(6, "Pourquoi mon programme Java compile mais ne s’exécute pas ?", loremIpsum, 2),
                    Question(7, "Comment convertir un String en int en Java sans lever d’exception ?", loremIpsum, 4),
                    Question(8, "Pourquoi Git indique 'nothing to commit, working tree clean' ?", loremIpsum, 7),
                    Question(9, "Comment centrer un div horizontalement et verticalement ?", loremIpsum, 10),
                    Question(10, "Pourquoi mon fetch retourne undefined ?", loremIpsum, 0),
                    Question(11, "Comment corriger une NullPointerException en Java ?", loremIpsum, 11),
                    Question(12, "Pourquoi ma boucle for est infinie ?", loremIpsum, 6),
                    Question(13, "Comment utiliser async/await correctement en JavaScript ?", loremIpsum, 5),
                    Question(14, "Pourquoi Docker ne détecte pas mes fichiers locaux ?", loremIpsum, 4),
                    Question(15, "Comment supprimer un commit déjà push sur GitHub ?", loremIpsum, 8),
                    Question(16, "Quelle est la différence entre LEFT JOIN et INNER JOIN en SQL ?", loremIpsum, 7),
                    Question(17, "Pourquoi mon application Android crash au démarrage ?", loremIpsum, 6),
                    Question(18, "Comment lire un fichier CSV en Python ?", loremIpsum, 5),
                    Question(19, "Pourquoi mon formulaire HTML ne soumet rien ?", loremIpsum, 2),
                    Question(20, "Comment gérer les erreurs 404 dans Spring Boot ?", loremIpsum, 4),
                    Question(21, "Pourquoi mon API retourne une erreur 500 ?", loremIpsum, 6),
                    Question(22, "Comment trier une liste d’objets en Java ?", loremIpsum, 5),
                    Question(23, "Pourquoi mon composant React se re-render en boucle ?", loremIpsum, 7),
                    Question(24, "Comment créer une clé étrangère en SQL ?", loremIpsum, 0),
                    Question(25, "Pourquoi mon push Git est rejeté (non-fast-forward) ?", loremIpsum, 8)
                )
            )
        )
    }

}