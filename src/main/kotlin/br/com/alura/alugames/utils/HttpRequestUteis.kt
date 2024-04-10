package br.com.alura.alugames.utils

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class HttpRequestUteis {
    fun httpGet(endereco: String): HttpResponse<String> {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder().uri(URI.create(endereco)).build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response
    }
}