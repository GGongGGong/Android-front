package com.example.ridingbud.ui.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ridingbud.databinding.ActivityMyBookmarkListBinding
import com.example.ridingbud.model.Course
import com.example.ridingbud.ui.adapter.CoursesAdapter
import com.example.ridingbud.viewmodel.MyBookmarksViewModel

class MyBookmarkListActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyBookmarkListBinding
    private val myBookmarksViewModel: MyBookmarksViewModel by viewModels()
    var courseData = mutableListOf(
        Course(0, "대구시내 근대골목 A코스", "10 km", "1 시간", 5.0, true),
        Course(0, "대구시내 근대골목 B코스", "9 km", "1 시간", 5.0, true),
        Course(0, "신천 금호강 상류 코스", "15 km", "2 시간", 4.5, true)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyBookmarkListBinding.inflate(layoutInflater)
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
        val coursesAdapter = CoursesAdapter()
        coursesAdapter.detailCourseListener =
            object : CoursesAdapter.DetailCourseListener {
                override fun onClick(course: Course) {
                    // 코스 자세히 보기로 이동
//                    val intent = Intent(this@MyBookmarkListActivity, )
//                    intent.putExtra(ApplicationClass.COURSE_ITEM, course)
//                    startActivity(intent)
                }
            }
        // RecyclerView 설정
        binding.myBookmarkRv.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = coursesAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
        // RecyclerView Item 설정
        coursesAdapter.submitList(courseData)
//        myBookmarksViewModel.myCourses.observe(this) {
//            myBookmarksAdapter.submitList(it)
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