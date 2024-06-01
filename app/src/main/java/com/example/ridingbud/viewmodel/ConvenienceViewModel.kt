package com.example.ridingbud.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ridingbud.model.Bicycle
import com.example.ridingbud.model.Course
import com.example.ridingbud.model.Review
import com.example.ridingbud.network.RetrofitUtil
import kotlinx.coroutines.launch

class ConvenienceViewModel : ViewModel() {
    private val _bicycleRentals = MutableLiveData<List<Bicycle>>()
    val bicycleRentals: LiveData<List<Bicycle>>
        get() = _bicycleRentals

    fun getMyReview(courseId: Int) {
        viewModelScope.launch {
            _bicycleRentals.value = RetrofitUtil.convenienceApi.getBicycleRentals().bicycleRentals
        }
    }
}