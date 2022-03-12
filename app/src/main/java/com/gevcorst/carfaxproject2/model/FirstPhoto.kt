package com.gevcorst.carfaxproject2.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FirstPhoto(
    val large: String = "",
    val medium: String = "",
    val small: String = ""
)