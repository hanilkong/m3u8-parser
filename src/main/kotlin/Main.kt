package org.example

import com.google.gson.Gson
import com.google.gson.JsonObject
import java.io.File
import java.nio.file.Paths
import javax.tools.JavaFileManager

data class TestModel ( val id: String, val test: String)

fun main() {
    println("Hello World!")
    val gson = Gson()
    val test = """
    {
        "id": "id",
        "test" : "test"
    }
    """
    val data = gson.fromJson<TestModel>(test, TestModel::class.java)
    val fileName = "master-playlist.m3u8"
    val resourceFile = Paths.get("src/main/resources", fileName).toString()
    println(data.id)
    println(resourceFile)
    readFileLineByLineUsingForEachLine(resourceFile)
}