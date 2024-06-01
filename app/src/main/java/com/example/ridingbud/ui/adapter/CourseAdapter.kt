package com.example.ridingbud.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ridingbud.databinding.ItemCourseBinding
import com.example.ridingbud.model.Course
class CourseAdapter(
    private val courses: List<Course>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(course: Course)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.bind(course)
    }

    override fun getItemCount() = courses.size

    inner class CourseViewHolder(private val binding: ItemCourseBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private lateinit var course: Course

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(course: Course) {
            this.course = course
            binding.courseName.text = course.courseName
            binding.distance.text = course.distance
            binding.time.text = course.time
            // 기타 데이터 바인딩
        }

        override fun onClick(v: View?) {
            itemClickListener.onItemClick(course)
        }
    }
}