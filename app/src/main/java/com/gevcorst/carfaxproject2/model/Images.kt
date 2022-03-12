package com.gevcorst.carfaxproject2.model


import androidx.room.Embedded
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Images(
    val baseUrl: String = "",
    val firstPhoto: FirstPhoto = FirstPhoto(),
    @Embedded
    val large: List<String> = listOf(),
    @Embedded
    val medium: List<String> = listOf(),
    @Embedded
    val small: List<String> = listOf()
)