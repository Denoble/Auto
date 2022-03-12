package com.gevcorst.carfaxproject2.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MonthlyPaymentEstimate(
    val downPaymentAmount: Double = 0.0,
    val downPaymentPercent: Int = 0,
    val interestRate: Int = 0,
    val loanAmount: Double = 0.0,
    val monthlyPayment: Double = 0.0,
    val price: Int = 0,
    val termInMonths: Int = 0
)