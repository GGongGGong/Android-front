package com.example.ridingbud.ui.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ridingbud.databinding.ItemReviewCourseBinding
import com.example.ridingbud.model.Course

class MyReviewsAdapter : ListAdapter<Course, MyReviewsAdapter.CoursesViewHolder>(
    CourseAllDiffCallback()
) {
    private lateinit var binding: ItemReviewCourseBinding

    inner class CoursesViewHolder(private val binding: ItemReviewCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setBind(course: Course) {
            binding.apply {
                // 코스 이름 설정
                courseName.text = course.courseName
                // 코스 거리 설정
                distance.text = course.distance
                // 코스 예상 시간 설정
                time.text = course.time
                // 코스 평점 설정
                rateNum.text = course.rate.toString()
                ratingbar.rating = course.rate.toFloat()
                // 코스 자세히 보기
                root.setOnClickListener {
                    detailCourseReviewListener.onClick(course = course)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        binding = ItemReviewCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoursesViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        holder.setBind(getItem(position))
    }

    interface DetailCourseReviewListener {
        fun onClick(course: Course)
    }

    lateinit var detailCourseReviewListener: DetailCourseReviewListener

}

class CourseAllDiffCallback : DiffUtil.ItemCallback<Course>() {
    override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem.courseId == newItem.courseId
    }

    override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem == newItem
    }
}