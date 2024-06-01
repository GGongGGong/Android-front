package com.example.ridingbud.model

data class CourseResponse(
    val message: String,
    val response: Map<String, List<Course>>
)