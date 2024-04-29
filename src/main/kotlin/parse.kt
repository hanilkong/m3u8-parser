package org.example

import java.io.File

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

fun readFileLineByLineUsingForEachLine(fileName: String)
        = File(fileName).forEachLine { println(it) }