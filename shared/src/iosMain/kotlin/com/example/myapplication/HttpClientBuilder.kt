package com.example.myapplication

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*


actual class HttpClientBuilder {
    actual fun build(
        block: HttpClientConfig<HttpClientEngineConfig>.() -> Unit
    ): HttpClient {
        return HttpClient(Ios, block)
    }
}