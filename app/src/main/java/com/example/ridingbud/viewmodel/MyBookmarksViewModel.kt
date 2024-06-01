package com.example.ridingbud.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ridingbud.model.Course
import com.example.ridingbud.network.RetrofitUtil
import kotlinx.coroutines.launch

class MyBookmarksViewModel : ViewModel() {
    private val _myCourses = MutableLiveData<List<Course>>()
    val myCourses: LiveData<List<Course>>
        get() = _myCourses

    init {
        getMyBookmarks()
    }

    private fun getMyBookmarks() {
        viewModelScope.launch {
            _myCourses.value = RetrofitUtil.courseApi.getMyCourses().response["boardDtoList"]
        }
    }
}