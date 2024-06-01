package com.example.ridingbud.model

import java.io.Serializable

data class MyProfileInfoBody(
    val nickname: String,
    val email: String,
    val statusMessage: String,
) : Serializable