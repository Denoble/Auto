package com.gevcorst.carfaxproject2.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class FirstPhoto(
    val large: String = "",
    val medium: String = "",
    val small: String = ""
):Parcelable