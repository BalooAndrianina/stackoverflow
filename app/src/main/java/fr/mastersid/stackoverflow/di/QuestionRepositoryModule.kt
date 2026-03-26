package fr.mastersid.stackoverflow.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import fr.mastersid.stackoverflow.repository.QuestionRepository
import fr.mastersid.stackoverflow.repository.QuestionRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class QuestionRepositoryModule {
    //TP3
    @Binds
    abstract fun bindQuestionRepository(questionRepositoryImpl: QuestionRepositoryImpl):
            QuestionRepository

    //TP2
//    @Binds
//    abstract fun bindQuestionRepository(questionRepositoryImpl: QuestionRepositoryDummyImpl):
//            QuestionRepository
}