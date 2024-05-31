package com.example.ridingbud.model

data class TokenInfo(
    val memberId: Int,
    val accessToken: String,
    val refreshToken: String
)