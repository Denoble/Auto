package com.gevcorst.carfaxproject2.model


import androidx.room.Embedded
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BedType(
    @Embedded
    val facets: List<Facet> = listOf()
)