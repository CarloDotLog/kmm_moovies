package com.example.myapplication

import io.ktor.client.*
import io.ktor.client.engine.*

expect class HttpClientBuilder() {
    fun build(
        block: HttpClientConfig<HttpClientEngineConfig>.() -> Unit
    ): HttpClient
}