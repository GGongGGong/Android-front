package com.example.ridingbud.model

import java.io.Serializable

data class ProfileInfo(
    val memberId: Int,
    val totalTreePoint: Int,
    val profileImage: String,
    val nickname: String,
    val email: String,
    val statusMessage: String,
) : Serializable