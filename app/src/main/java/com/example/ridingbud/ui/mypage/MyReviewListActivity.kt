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
import com.example.ridingbud.ui.adapter.MyReviewsAdapter
import com.example.ridingbud.viewmodel.MyReviewListViewModel

class MyReviewListActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyReviewListBinding
    private val myReviewListViewModel: MyReviewListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyReviewListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()
        setUi()
    }

    private fun setAdapter() {
        // Adapter 설정
        val myReviewsAdapter = MyReviewsAdapter()
        myReviewsAdapter.detailCourseReviewListener =
            object : MyReviewsAdapter.DetailCourseReviewListener {
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
            adapter = myReviewsAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
        // RecyclerView Item 설정
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