package fr.mastersid.stackoverflow.webservices

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

private const val BASE_URL = "https://api.stackexchange.com/2.3/"

//module d'injection d'instance de retrofit et StackOverFlowWebservice rélisé par retrofit
@Module
@InstallIn(SingletonComponent::class)
class StackOverFlowWebServiceModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun provideStackOverFlowWebService(retrofit: Retrofit): StackOverFlowWebService{
        return retrofit.create(StackOverFlowWebService::class.java)
    }
}