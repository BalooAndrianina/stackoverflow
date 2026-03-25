package fr.mastersid.stackoverflow.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.mastersid.stackoverflow.db.QuestionDao
import fr.mastersid.stackoverflow.db.QuestionRoomDatabase

@Module
@InstallIn(SingletonComponent::class)
object QuestionRoomDatabaseModule {

    @Provides
    fun provideQuestionDao(questionRoomDatabase: QuestionRoomDatabase) : QuestionDao {
        return questionRoomDatabase.questionDao()
    }

    @Provides
    fun provideQuestionRoomDatabase(@ApplicationContext appContext: Context): QuestionRoomDatabase {
        return Room.databaseBuilder(
            appContext,
            QuestionRoomDatabase::class.java,
            "question_database"
        ).build()
    }
}