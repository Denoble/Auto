package com.gevcorst.carfaxproject2.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class HistoryX(
    val city: String = "",
    val date: String = "",
    val description: String = "",
    val odometerReading: Int = 0,
    val source: String = "",
    val state: String = ""
):Parcelable