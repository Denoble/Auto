package com.gevcorst.carfaxproject2.model


import android.os.Parcelable
import androidx.room.Embedded
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class VehicleUseHistory(
    @Embedded
    val history: List<HistoryXX> = listOf(),
    val icon: String = "",
    val iconUrl: String = "",
    val text: String = ""
):Parcelable