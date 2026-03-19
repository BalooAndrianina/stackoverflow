package fr.mastersid.stackoverflow.webservices

import com.squareup.moshi.Moshi
import com.squareup.moshi.addAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.mastersid.stackoverflow.adapter.QuestionMoshiAdapter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.stackexchange.com/2.3/"

//module d'injection d'instance de retrofit et StackOverFlowWebservice rélisé par retrofit
@Module
@InstallIn(SingletonComponent::class)
class StackOverFlowWebServiceModule {

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(QuestionMoshiAdapter())
            .build()
    }

    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun provideStackOverFlowWebService(retrofit: Retrofit): StackOverFlowWebService{
        return retrofit.create(StackOverFlowWebService::class.java)
    }
}