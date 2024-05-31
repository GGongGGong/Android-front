package com.example.ecomate.model

import com.example.ridingbud.model.TokenInfo

data class LogInResponse(
    val message: String,
    val response: TokenInfo
)