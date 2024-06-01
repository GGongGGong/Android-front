package com.example.ridingbud.network

import com.example.ridingbud.ApplicationClass

class RetrofitUtil {
    companion object {
        val logInApi: LogInApi = ApplicationClass.retrofit.create(LogInApi::class.java)
        val courseApi: CourseApi = ApplicationClass.retrofit.create(CourseApi::class.java)
        val memberApi: MemberApi = ApplicationClass.retrofit.create(MemberApi::class.java)
        val convenienceApi: ConvenienceApi = ApplicationClass.retrofit.create(ConvenienceApi::class.java)
    }
}