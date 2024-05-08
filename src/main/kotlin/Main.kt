package org.example

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.nio.file.Paths

const val baseUrl = "https://test-streams.mux.dev/x36xhzz/"
@OptIn(ExperimentalStdlibApi::class)
suspend fun main() {
    println("Hello World!")
    val client = HttpClient(CIO)

    val fileName = "master-playlist.m3u8"
    val resourceFile = Paths.get("src/main/resources", fileName).toString()
    println(resourceFile)
    val m3u8UrlArray =  m3u8Parser(resourceFile, ".m3u8")
    if(m3u8UrlArray.isNotEmpty()) {
        val response: HttpResponse = client.get(m3u8UrlArray[0])
        val body = response.body<String>()
        val bodyToArray = body.split("\n")
        val filterTsArray = bodyToArray.filter { Regex(".ts").find(it) != null }
        if(filterTsArray.isNotEmpty()) {
            val tsResponse = client.get("${baseUrl}url_0/${filterTsArray[0]}")
            val tsBody = tsResponse.body<ByteArray>().toHexString()
            println(tsBody)
        }
    }
    client.close()
}