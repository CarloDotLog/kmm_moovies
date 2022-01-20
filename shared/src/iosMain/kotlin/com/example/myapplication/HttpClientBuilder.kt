package com.example.myapplication

actual class HttpClientBuilder {
    actual fun build(block: ...): HttpClient {
        return HttpClient(Ios, block)
    }
}