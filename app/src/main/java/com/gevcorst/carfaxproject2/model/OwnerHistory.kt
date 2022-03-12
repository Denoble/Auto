package com.gevcorst.carfaxproject2.model


import android.os.Parcelable
import androidx.room.Embedded
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class OwnerHistory(
    @Embedded
    val history: List<History> = listOf(),
    val icon: String = "",
    val iconUrl: String = "",
    val text: String = ""
):Parcelable