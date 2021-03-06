package example

import io.ktor.client.HttpClient
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import io.ktor.utils.io.core.use

fun healthCheck(): String {
    println("testing health check")
    return runBlocking {
        HttpClient().use {
            it.request<HttpResponse>("https://robinhood.com/healthcheck") {}
                .readText()
        }
    }
}
