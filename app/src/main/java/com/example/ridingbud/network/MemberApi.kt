package com.example.ridingbud.network

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

interface MemberApi {
    @GET("v1/members/my-profile")
    suspend fun getMyProfile(): ProfileResponse

    @GET("v1/members/{memberId}")
    suspend fun getUserProfile(
        @Path("memberId") memberId: Int
    ): ProfileResponse

    @Multipart
    @POST("v1/members/profile-image")
    suspend fun postMyProfileImage(
        @Part profileImage: MultipartBody.Part
    )

    @PUT("v1/members")
    suspend fun postMyProfileInfo(
        @Body myProfileInfo: MyProfileInfoBody
    )
}