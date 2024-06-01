package com.example.ridingbud.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ridingbud.model.Course
import com.example.ridingbud.model.Review
import com.example.ridingbud.network.RetrofitUtil
import kotlinx.coroutines.launch

class MyReviewViewModel : ViewModel() {
    private val _myReview = MutableLiveData<Review>()
    val myReview: LiveData<Review>
        get() = _myReview

    fun getMyReview(courseId: Int) {
        viewModelScope.launch {
            _myReview.value = RetrofitUtil.courseApi.getMyReview(courseId).response
        }
    }
}