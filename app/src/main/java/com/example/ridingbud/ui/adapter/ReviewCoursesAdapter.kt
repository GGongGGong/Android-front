package com.example.ridingbud.ui.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ridingbud.R
import com.example.ridingbud.databinding.ItemCourseBinding
import com.example.ridingbud.databinding.ItemReviewCourseBinding
import com.example.ridingbud.model.Course

class ReviewCoursesAdapter : ListAdapter<Course, ReviewCoursesAdapter.BoardsViewHolder>(
    CoursesDiffCallback()
) {
    private lateinit var binding: ItemReviewCourseBinding

    inner class BoardsViewHolder(private val binding: ItemReviewCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.Q)
        fun setBind(course: Course) {
            binding.apply {
                courseName.text = course.courseName
                distance.text = course.distance
                time.text = course.time
                rateNum.text = course.rate.toString()
                ratingbar.rating = course.rate.toFloat()
                root.setOnClickListener {
                    detailReviewListener.onClick(course = course)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardsViewHolder {
        binding = ItemReviewCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardsViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: BoardsViewHolder, position: Int) {
        holder.setBind(getItem(position))
    }

    interface DetailReviewListener {
        fun onClick(course: Course)
    }

    lateinit var detailReviewListener: DetailReviewListener
}

class CoursesDiffCallback : DiffUtil.ItemCallback<Course>() {
    override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem.courseId == newItem.courseId
    }

    override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem == newItem
    }
}