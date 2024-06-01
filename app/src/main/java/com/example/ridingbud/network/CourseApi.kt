package com.example.ridingbud.network

import com.example.ridingbud.model.CourseResponse
import com.example.ridingbud.model.ProfileResponse
import com.example.ridingbud.model.ReviewResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CourseApi {
    @GET("v1/courses")
    suspend fun getCourses(): CourseResponse

    @GET("v1/courses/bookmarks")
    suspend fun getMyCourses(): CourseResponse

    @GET("v1/courses/reviewed")
    suspend fun getMyReviewCourses(): CourseResponse

    @GET("v1/courses/{courseId}")
    suspend fun getMyReview(
        @Path("courseId") courseId: Int
    ): ReviewResponse
}