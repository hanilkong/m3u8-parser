package org.example

import java.io.File
import java.util.regex.Pattern

val start = "#"
val startTag: String = "EXTM3U"
val fileVersionTag: String = "EXT-X-VERSION"
val audioPropertyTag: String = "EXT-X-MEDIA"
val audioTYPE: String = "TYPE"
val audioGROUPID: String = "GROUP-ID"
val audioNAME: String = "NAME"
val audioDEFAULT: String = "DEFAULT"
val audioAUTOSELECT: String = "AUTOSELECT"
val audioLANGUAGE: String = "LANGUAGE"
val audioCHANNELS: String = "CHANNELS"

val videoPropertyTag: String = "EXT-X-STREAM-INF"
val videoBANDWIDTH: String = "BANDWIDTH"
val videoAVERAGEBANDWIDTH: String = "AVERAGE-BANDWIDTH"
val videoFRAMERATE: String = "FRAME-RATE"
val videoHDCPLEVEL: String = "HDCP-LEVEL"
val videoRESOLUTION: String = "RESOLUTION"
val videoVIDEORANGE: String = "VIDEO-RANGE"
val videoCODECS: String = "CODECS"
val videoAudioGroupID: String = "AUDIO"
val tagList = arrayListOf<String>(
    "EXT-X-VERSION",
    "EXT-X-MEDIA",
    "EXT-X-MEDIA",
    "TYPE",
    "GROUP-ID",
    "NAME",
    "DEFAULT",
    "AUTOSELECT",
    "LANGUAGE",
    "CHANNELS",
    "EXT-X-STREAM-INF",
    "BANDWIDTH",
    "AVERAGE-BANDWIDTH",
    "FRAME-RATE",
    "HDCP-LEVEL",
    "RESOLUTION",
    "VIDEO-RANGE"
)

fun readFileLineByLineUsingForEachLine(fileName: String)
        = File(fileName).forEachLine {
            val matchResult = Regex("#").find(it)
            if(matchResult != null) {
                println("-------------------------------------------------------")
                val nameAndTagList = it.split(":")
                println(nameAndTagList)
                if(nameAndTagList[0] == "#EXT-X-MEDIA") {
                    val tagList = nameAndTagList[1].split(",")
                    println(nameAndTagList[0])
                    tagList.forEach { tagItem ->
                        val tag = tagItem.split("=")
                        println("${tag[0]}: ${tag[1]}")
                    }
                }
            } else {
                val isM3u8 = Regex(".m3u8").find(it)
                if(isM3u8 != null) {
                    println("url: https://skbcdn-aws-vod.cdn.wavve.com/vod/4Y/1000536033/TH/KO/240403011008/${it}")
                }
            }

        }