package com.gevcorst.carfaxproject2.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ServiceHistory(
    val history: List<HistoryX> = listOf(),
    val icon: String = "",
    val iconUrl: String = "",
    val number: Int = 0,
    val text: String = ""
):Parcelable