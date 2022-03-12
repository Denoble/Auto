package com.gevcorst.carfaxproject2.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class HistoryXX(
    val averageMilesPerYear: Int = 0,
    val ownerNumber: Int = 0,
    val useType: String = ""
):Parcelable