package com.example.ridingbud.network

import com.example.ridingbud.ApplicationClass

class RetrofitUtil {
    companion object {
        val logInApi: LogInApi = ApplicationClass.retrofit.create(LogInApi::class.java)
    }
}