package com.example.ridingbud.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ridingbud.model.MyProfileInfoBody
import com.example.ridingbud.model.ProfileInfo
import com.example.ridingbud.network.RetrofitUtil
import kotlinx.coroutines.launch
import okhttp3.MultipartBody

class ProfileSettingViewModel : ViewModel() {
    private val _ProfileInfo = MutableLiveData<ProfileInfo>()
    val profileInfo: LiveData<ProfileInfo>
        get() = _ProfileInfo

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getMyProfile()
    }

    private fun getMyProfile() {
        viewModelScope.launch {
            _ProfileInfo.value = RetrofitUtil.memberApi.getMyProfile().response
        }
    }

    fun postMyProfileImage(profileImage: MultipartBody.Part) {
        showProgress()
        viewModelScope.launch {
            RetrofitUtil.memberApi.postMyProfileImage(profileImage)
            hideProgress()
        }
    }

    fun postMyProfileInfo(
        nickname: String,
        email: String,
        statusMessage: String
    ) {
        viewModelScope.launch {
            RetrofitUtil.memberApi.postMyProfileInfo(
                MyProfileInfoBody(
                nickname,
                email,
                statusMessage
            )
            )
        }
    }

    fun showProgress() {
        _isLoading.value = true
    }

    fun hideProgress() {
        _isLoading.value = false
    }
}