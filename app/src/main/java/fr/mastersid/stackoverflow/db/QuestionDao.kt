package fr.mastersid.stackoverflow.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.mastersid.stackoverflow.data.Question
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Question>)

    //creation de flow sur lequel je vais m'abonner via le VM
    // @Query pour faire une requête SQL
    @Query("SELECT * FROM question_table")
    fun getQuestionListFlow(): Flow<List<Question>>
}