package com.example.ridingbud.model

import com.example.ridingbud.model.PumpsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ConvenienceService {
    @GET("/facilities/pumps")
    fun getPumpStations(): Call<PumpsResponse>
}
