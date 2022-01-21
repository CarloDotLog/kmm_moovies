package com.example.myapplication.features.trending.data.datasource

import com.example.myapplication.HttpClientBuilder
import com.example.myapplication.features.trending.data.model.MovieModel
import com.example.myapplication.features.trending.data.model.TrendingResponseModel
import io.ktor.client.features.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*

class RemoteDatasource {

    val BASE_URL = "api.themoviedb.org/3"
    val API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0MTMyYzlhYTM2MGVjMzcyNmEyMzEzNzkyZmJhZjQwOCIsInN1YiI6IjYxZTkxOTUwNTdkMzc4MDA5NzY3Y2RkYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.H-nIkwCp57E-nQSaqdNE8_pK_1DDd8s4cdIIyVXCxOE"

    suspend fun getTrendingMovies(): List<MovieModel> {

        // ktor api call
        var client = HttpClientBuilder().build {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                }
                )
            }
            install(Logging)
            install(Auth) { bearer {
                loadTokens {
                    BearerTokens(API_KEY, API_KEY) }
            } }
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                }
                host = BASE_URL
            }
        }

        var response = client.get<TrendingResponseModel>("/trending/all/day") { headers {
            append(HttpHeaders.Accept, "text/json")
            append(HttpHeaders.UserAgent, "ktor client") }
        }

        // Todo come controllo response?

        return response.movies
    }
}