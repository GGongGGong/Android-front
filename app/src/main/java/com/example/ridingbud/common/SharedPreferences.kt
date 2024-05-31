package com.example.ridingbud.common

import android.content.Context
import android.content.SharedPreferences
import com.example.ridingbud.ApplicationClass.Companion.ACCESS_TOKEN
import com.example.ridingbud.ApplicationClass.Companion.MEMBER_ID
import com.example.ridingbud.ApplicationClass.Companion.REFRESH_TOKEN

class SharedPreferences(context: Context) {
    private var preferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun setMemberId(memberId: Int) {
        val editor = preferences.edit()
        editor.putInt(MEMBER_ID, memberId)
        editor.apply()
    }

    fun getMemberId(): Int {
        return preferences.getInt(MEMBER_ID, 0)
    }

    fun setAccessToken(accessToken: String) {
        val editor = preferences.edit()
        editor.putString(ACCESS_TOKEN, accessToken)
        editor.apply()
    }

    fun getAccessToken(): String {
        return preferences.getString(ACCESS_TOKEN, "").toString()
    }

    fun setRefreshToken(refreshToken: String) {
        val editor = preferences.edit()
        editor.putString(REFRESH_TOKEN, refreshToken)
        editor.apply()
    }

    fun getRefreshToken(): String {
        return preferences.getString(REFRESH_TOKEN, "").toString()
    }

    fun deleteToken() {
        val editor = preferences.edit()
        editor.remove(MEMBER_ID)
        editor.remove(ACCESS_TOKEN)
        editor.remove(REFRESH_TOKEN)
        editor.apply()
    }

    companion object {
        private const val SHARED_PREFERENCES_NAME = "ecoMate"
    }
}