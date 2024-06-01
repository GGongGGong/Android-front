package com.example.ridingbud.model

import java.io.Serializable

data class Course(
    val courseId: Int,
    val courseName: String,
    val distance: String,
    val time: String,
    val rate: Double,
    val isBookmarked: Boolean,
) : Serializable
