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
import com.example.ridingbud.model.Course

class CoursesAdapter : ListAdapter<Course, CoursesAdapter.BoardsViewHolder>(
    BoardAllDiffCallback()
) {
    private lateinit var binding: ItemCourseBinding

    inner class BoardsViewHolder(private val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.Q)
        fun setBind(course: Course) {
            binding.apply {
                courseName.text = course.courseName
                distance.text = course.distance
                time.text = course.time
                if (course.isBookmarked) bookmarkBtn.setImageResource(R.drawable.bookmark_on_icon)
                else bookmarkBtn.setImageResource(R.drawable.bookmark_off_icon)
                bookmarkBtn.setOnClickListener {

                }
                root.setOnClickListener {
                    detailCourseListener.onClick(course = course)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardsViewHolder {
        binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardsViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: BoardsViewHolder, position: Int) {
        holder.setBind(getItem(position))
    }

    interface DetailCourseListener {
        fun onClick(course: Course)
    }

    lateinit var detailCourseListener: DetailCourseListener
}

class BoardAllDiffCallback : DiffUtil.ItemCallback<Course>() {
    override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem.courseId == newItem.courseId
    }

    override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem == newItem
    }
}
