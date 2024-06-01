package com.example.ridingbud.model

import java.io.Serializable

data class Review(
    val courseId: Int,
    val courseName: String,
    val rate: Double,
    val date: String,
    val content: String,
    val likeNum: Int,
) : Serializable
