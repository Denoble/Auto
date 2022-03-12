package com.gevcorst.carfaxproject2.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class History(
    val city: String = "",
    val endOwnershipDate: String = "",
    val ownerNumber: Int = 0,
    val purchaseDate: String = "",
    val state: String = ""
):Parcelable