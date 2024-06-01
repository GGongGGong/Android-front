package com.example.ridingbud

import android.app.Application
import com.example.ridingbud.common.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kakao.sdk.common.KakaoSdk
import com.kakao.vectormap.KakaoMapSdk
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass : Application() {

    companion object {
        const val SERVER_URL = "http://www.riding-bud.shop/api/"
        lateinit var retrofit: Retrofit
        lateinit var sharedPreferencesUtil: SharedPreferences
        const val MEMBER_ID = "memberId"
        const val ACCESS_TOKEN = "accessToken"
        const val REFRESH_TOKEN = "refreshToken"
        const val COURSE_ITEM = "courseItem"
    }

    override fun onCreate() {
        super.onCreate()

        // Kakao (Map) SDK 초기화 - Native Key 필요
//        KakaoSdk.init(this, "")
        KakaoMapSdk.init(this, "91b8238b24afff9e6a6e914eb3fa086d")

        sharedPreferencesUtil = SharedPreferences(applicationContext)
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val token = sharedPreferencesUtil.getAccessToken() // 저장된 JWT 토큰을 가져옵니다.

                // JWT 토큰을 Authorization 헤더에 첨부합니다.
                val requestBuilder = originalRequest.newBuilder()
                    .header("Authorization", "Bearer $token")
                    .method(originalRequest.method, originalRequest.body)

                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .addInterceptor(loggingInterceptor)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    private val gson: Gson = GsonBuilder()
        .setLenient()
        .create()
}