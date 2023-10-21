import br.com.alura.guilherme_rm88080_mateus_rm89205.models.CatModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApiService {
    @GET("images/search?size=large")
    suspend fun getCats(@Query("api_key") apiKey: String, @Query("limit") limit: Int): List<CatModel>

    companion object {
        fun create(): CatApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com/v1/") // URL base da API
                .addConverterFactory(GsonConverterFactory.create()) // Converter para Gson
                .build()

            return retrofit.create(CatApiService::class.java)
        }
    }
}

