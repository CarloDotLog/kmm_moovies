package com.example.myapplication

import io.ktor.client.*
import io.ktor.client.engine.*


actual class HttpClientBuilder {
    actual fun build(
        block: HttpClientConfig<HttpClientEngineConfig>.() -> Unit
    ): HttpClient {
        TODO("To be implemented")
    }
}