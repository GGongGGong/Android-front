package com.example.ridingbud.ui.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ridingbud.databinding.ActivityMyBookmarkListBinding
import com.example.ridingbud.model.Course
import com.example.ridingbud.ui.adapter.MyBookmarksAdapter
import com.example.ridingbud.viewmodel.MyBookmarksViewModel

class MyBookmarkListActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyBookmarkListBinding
    private val myBookmarksViewModel: MyBookmarksViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyBookmarkListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()
        setUi()
    }

    private fun setAdapter() {
        // Adapter 설정
        val myBookmarksAdapter = MyBookmarksAdapter()
        myBookmarksAdapter.detailCourseListener =
            object : MyBookmarksAdapter.DetailCourseListener {
                override fun onClick(course: Course) {
                    // 코스 자세히 보기로 이동
//                    val intent = Intent(this@MyBookmarkListActivity, )
//                    intent.putExtra(ApplicationClass.COURSE_ITEM, course)
//                    startActivity(intent)
                }
            }
        myBookmarksAdapter.deleteCourseListener =
            object : MyBookmarksAdapter.DeleteCourseListener {
                override fun onClick(course: Course) {
                    // 사용자의 Bookmark에서 해당 코스 제거

                }
            }
        // RecyclerView 설정
        binding.myBookmarkRv.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = myBookmarksAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
        // RecyclerView Item 설정
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