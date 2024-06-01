package com.example.ridingbud.ui.adapter
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ridingbud.databinding.ItemCourseBinding
import com.example.ridingbud.model.CourseItem

class CoursesAdapter(private var courses: List<CourseItem>) : RecyclerView.Adapter<CoursesAdapter.CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(courses[position])
    }

    override fun getItemCount() = courses.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateCourses(newCourses: List<CourseItem>) {
        courses = newCourses
        notifyDataSetChanged()
    }

    class CourseViewHolder(private val binding: ItemCourseBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(course: CourseItem) {
            binding.courseName.text = course.name
            binding.distance.text = course.distance
            binding.time.text = course.time
            // rating이 XML에 없으므로 이 부분은 생략합니다.
        }
    }
}
