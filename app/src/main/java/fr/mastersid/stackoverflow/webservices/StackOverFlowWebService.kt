package fr.mastersid.stackoverflow.webservices

// questions?pagesize=20&order=desc&sort=activity&site=stackoverflow
import retrofit2.Response
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StackOverFlowWebService {
    @GET("question?site=stackoverflow") //on ecrit la requête suivi des params constants
    suspend fun getQuestionList( //params de la methode pour les params non constants
        @Query("pagesize") pagesize : Int = 20,
        @Query("order") order : String,
        @Query("sort") sort : String
    ): Response<ResponseBody>
}