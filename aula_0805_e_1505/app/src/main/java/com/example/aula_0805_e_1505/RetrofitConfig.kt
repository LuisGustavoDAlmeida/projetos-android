import com.example.aula_0805_e_1505.BuildConfig
import com.example.aula_0805_e_1505.Musica
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


object RetrofitConfig {

    val instance = Retrofit
        .Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

interface MusicaService {
    @GET("/musicas")
    suspend fun listarMusicas(
        @Header("Authorization") token: String
    ): Response<List<Musica>>
}

interface MusicaServiceMock : MusicaService {
    @GET("/musicas")
    suspend fun listarMusicasMock(
        @Header("Authorization") token: String = "mock"
    ): Response<List<Musica>>
}

interface AuthService {
    @POST("/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>
}

data class LoginResponse(val token: String)
data class LoginRequest(
    val username: String,
    val password: String
)