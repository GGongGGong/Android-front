package com.example.ridingbud.network

import com.example.ridingbud.model.BicycleRentalResponse
import com.example.ridingbud.model.MyProfileInfoBody
import com.example.ridingbud.model.ProfileResponse
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface ConvenienceApi {
    @GET("facilities/bicycles")
    suspend fun getBicycleRentals(): BicycleRentalResponse
}