package com.example.ridingbud.model

import java.io.Serializable

data class Bicycle(
    val bicycleRentalId: Long,
    val x: Float,
    val y: Float,
    val stationName: String,
    val totalCount: Short,
    val remainder: Short,
    val operationTime: String,
    val detailLocation: String,
    val call : String,
) : Serializable
