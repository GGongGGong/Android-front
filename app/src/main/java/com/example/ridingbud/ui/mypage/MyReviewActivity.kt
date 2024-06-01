package com.example.ridingbud.ui.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.ridingbud.ApplicationClass.Companion.COURSE_ITEM
import com.example.ridingbud.databinding.ActivityMyReviewBinding
import com.example.ridingbud.model.Course
import com.example.ridingbud.viewmodel.MyReviewViewModel

class MyReviewActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyReviewBinding
    lateinit var course: Course
    private val myReviewViewModel: MyReviewViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        course = intent.getSerializableExtra(COURSE_ITEM) as Course
//        myReviewViewModel.getMyReview(course.courseId)

        setUi()
    }

    private fun setUi() {
        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }

            // 리뷰 정보 설정
//            myReviewViewModel.myReview.observe(this@MyReviewActivity) {
//                // 코스 이름 설정
//                courseName.text = it.courseName
//                // 코스 평점 설정
//                ratingbar.rating = it.rate.toFloat()
//                rateNum.text = it.rate.toString()
//                // 날짜 설정
//                date.text = it.date
//                // 리뷰 내용 설정
//                reviewContent.text = it.content
//                // 좋아요 개수 설정
//                likeNum.text = "좋아요 ${it.likeNum}개"
//            }
            // 리뷰 수정 기능
            editBtn.setOnClickListener {

            }
            // 리뷰 삭제 기능
            deleteBtn.setOnClickListener {

            }
        }
    }
}