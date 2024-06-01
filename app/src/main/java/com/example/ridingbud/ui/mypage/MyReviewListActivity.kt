package com.example.ridingbud.ui.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ridingbud.ApplicationClass
import com.example.ridingbud.databinding.ActivityMyReviewListBinding
import com.example.ridingbud.model.Course
import com.example.ridingbud.ui.adapter.ReviewCoursesAdapter
import com.example.ridingbud.viewmodel.MyReviewListViewModel

class MyReviewListActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyReviewListBinding
    private val myReviewListViewModel: MyReviewListViewModel by viewModels()
    var courseData = mutableListOf(
        Course(0, "대구시내 근대골목 A코스", "10 km", "1 시간", 5.0, true),
        Course(0, "대구시내 근대골목 B코스", "9 km", "1 시간", 5.0, true),
        Course(0, "신천 금호강 상류 코스", "15 km", "2 시간", 4.5, true)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyReviewListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()
        setUi()
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0,0)
    }

    private fun setAdapter() {
        // Adapter 설정
        val reviewCoursesAdapter = ReviewCoursesAdapter()
        reviewCoursesAdapter.detailReviewListener =
            object : ReviewCoursesAdapter.DetailReviewListener {
                override fun onClick(course: Course) {
                    // 코스 리뷰 자세히 보기로 이동
                    val intent = Intent(this@MyReviewListActivity, MyReviewActivity::class.java)
                    intent.putExtra(ApplicationClass.COURSE_ITEM, course)
                    startActivity(intent)
                }
            }
        // RecyclerView 설정
        binding.myReviewRv.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = reviewCoursesAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
        // RecyclerView Item 설정
        reviewCoursesAdapter.submitList(courseData)
//        myReviewListViewModel.myReviewCourses.observe(this) {
//            myReviewsAdapter.submitList(it)
//        }
    }

    private fun setUi() {
        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }
        }
    }
}