package fr.mastersid.stackoverflow.repository

import fr.mastersid.stackoverflow.data.QuestionResponse
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    val questionResponse: Flow<QuestionResponse> //déclaration de weatherResponse sous forme de flux
    suspend fun updateQuestionInfo() //fonction suspendable??
}

//Un flow permet d’´emettre des donn´ees de mani`ere asynchrone :
//au niveau du ViewModel, on pourra s’abonner `a la collecte de ces
//donn´ees `a l’int´erieur d’une coroutine et la stocker dans une LiveData
//il y a deux types de flow :
//▶ un cold flow est g´en´eralement un flux d’op´erations donnant lieu `a
//l’´emission de plusieurs valeurs, sur un fil d’ex´ecution sp´ecifique (une
//coroutine) ; l’ex´ecution de ce flux d’op´erations ne sera d´emarr´e que
//lorsqu’au moins un abonn´e sera prˆet `a collecter les valeurs ´emises
//▶ un hot flow ´emet ´egalement des valeurs `a partir d’un fil d’ex´ecution
//sp´ecifique (une coroutine) ; cette ´emission est faite qu’il y ait ou qu’il
//n’y ait pas d’abonn´e pour collecter les valeurs ´emises
//Dans notre cas, on utilisera un hot flow de type MutableSharedFlow