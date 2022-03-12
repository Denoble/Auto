package com.gevcorst.carfaxproject2.model


import androidx.room.Embedded
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AccidentHistory(
    val accidentSummary: List<String> = listOf(),
    val icon: String = "",
    val iconUrl: String = "",
    val text: String = ""
)