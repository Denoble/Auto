package com.gevcorst.carfaxproject2.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BreadCrumb(
    val label: String = "",
    val link: String = "",
    val position: Int = 0
)