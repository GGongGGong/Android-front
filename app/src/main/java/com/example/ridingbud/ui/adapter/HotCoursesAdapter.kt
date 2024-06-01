package com.example.ridingbud.ui.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ridingbud.databinding.ItemHotCourseBinding
import com.example.ridingbud.model.CourseItem

class HotCoursesAdapter(private val courses: List<CourseItem>) : RecyclerView.Adapter<HotCoursesAdapter.HotCourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotCourseViewHolder {
        val binding = ItemHotCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotCourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotCourseViewHolder, position: Int) {
        holder.bind(courses[position])
    }

    override fun getItemCount() = courses.size

    class HotCourseViewHolder(private val binding: ItemHotCourseBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(course: CourseItem) {
            binding.courseName.text = course.name
            binding.courseDistance.text = course.distance
            binding.courseTime.text = course.time
            binding.courseRating.text = course.rating.toString()
        }
    }
}