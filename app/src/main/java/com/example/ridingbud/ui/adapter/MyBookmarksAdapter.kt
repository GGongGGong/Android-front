package com.example.ridingbud.ui.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ridingbud.databinding.ItemCourseBinding
import com.example.ridingbud.model.Course

class MyBookmarksAdapter : ListAdapter<Course, MyBookmarksAdapter.CoursesViewHolder>(
    BoardAllDiffCallback()
) {
    private lateinit var binding: ItemCourseBinding

    inner class CoursesViewHolder(private val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.Q)
        fun setBind(course: Course) {
            binding.apply {
                // 코스 이름 설정
                courseName.text = course.courseName
                // 코스 거리 설정
                distance.text = course.distance
                // 코스 예상 시간 설정
                time.text = course.time
                // 즐겨찾기 버튼 설정
                bookmarkBtn.setOnClickListener {
                    deleteCourseListener.onClick(course = course)
                }
                // 코스 자세히 보기
                root.setOnClickListener {
                    detailCourseListener.onClick(course = course)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoursesViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        holder.setBind(getItem(position))
    }

    interface DetailCourseListener {
        fun onClick(course: Course)
    }
    interface DeleteCourseListener {
        fun onClick(course: Course)
    }

    lateinit var detailCourseListener: DetailCourseListener
    lateinit var deleteCourseListener: DeleteCourseListener

}

class BoardAllDiffCallback : DiffUtil.ItemCallback<Course>() {
    override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem.courseId == newItem.courseId
    }

    override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem == newItem
    }
}