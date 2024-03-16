package api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import model.UsersDataClass


class ApiClass {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun githubUsers(): List<UsersDataClass>{
        val response = client.get("https://api.github.com/users?per_page=100")
     /*   {
            headers {
                append(HttpHeaders.Authorization, ApiHeader.auth)
            }
        }*/

        return response.body()
    }

/*    suspend fun searchImage(url:String): ImageDataClass {
        val response = client.get(url)
        {
            headers {
                append(HttpHeaders.Authorization, ApiHeader.auth)
            }
        }

        return response.body()
    }*/
}