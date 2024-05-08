package org.example

import java.io.File
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*


fun m3u8Parser(fileName: String, extension: String): ArrayList<String> {
    val urlArray = ArrayList<String>()
    File(fileName).forEachLine {
        val matchResult = Regex("#").find(it)
        if(matchResult != null) {
//            println("-------------------------------------------------------")
            val nameAndTagList = it.split(":")
//            println(nameAndTagList)
            if(nameAndTagList[0] == "#EXT-X-MEDIA") {
                val tagList = nameAndTagList[1].split(",")
//                println(nameAndTagList[0])
                tagList.forEach { tagItem ->
                    val tag = tagItem.split("=")
                    println("${tag[0]}: ${tag[1]}")
                }
            }
        } else {
            val result = Regex(extension).find(it)
            if(result != null) {
//                println("url: https://test-streams.mux.dev/x36xhzz/${it}")
                urlArray.add("${baseUrl}${it}")
            }
        }
    }
    return urlArray
}