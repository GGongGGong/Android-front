package com.example.ridingbud.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ridingbud.model.Course
import com.example.ridingbud.network.RetrofitUtil
import kotlinx.coroutines.launch

class MyReviewListViewModel : ViewModel() {
    private val _myReviewCourses = MutableLiveData<List<Course>>()
    val myReviewCourses: LiveData<List<Course>>
        get() = _myReviewCourses

    init {
        getMyReviewList()
    }

    private fun getMyReviewList() {
        viewModelScope.launch {
            _myReviewCourses.value = RetrofitUtil.courseApi.getMyReviewCourses().response["boardDtoList"]
        }
    }
}