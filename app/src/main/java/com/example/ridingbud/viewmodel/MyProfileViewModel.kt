package com.example.ridingbud.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ridingbud.model.ProfileInfo
import com.example.ridingbud.network.RetrofitUtil
import kotlinx.coroutines.launch

class MyProfileViewModel : ViewModel() {
    private val _profileInfo = MutableLiveData<ProfileInfo>()
    val profileInfo: LiveData<ProfileInfo>
        get() = _profileInfo

    init {
        getMyProfile()
    }

    fun getMyProfile() {
        viewModelScope.launch {
            _profileInfo.value = RetrofitUtil.memberApi.getMyProfile().response
        }
    }
}