package com.gevcorst.carfaxproject2.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OnePriceArrow(
    val arrow: String = "",
    val arrowUrl: String = "",
    val icon: String = "",
    val iconUrl: String = "",
    val order: Int = 0,
    val text: String = ""
)