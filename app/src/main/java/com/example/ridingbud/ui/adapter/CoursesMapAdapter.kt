package com.example.ridingbud.ui.adapter

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ridingbud.databinding.ItemCourseMapBinding
import com.example.ridingbud.model.Course

class CoursesMapAdapter : ListAdapter<Course, CoursesMapAdapter.BoardsViewHolder>(
    CoursesMapDiffCallback()
) {
    private lateinit var binding: ItemCourseMapBinding

    inner class BoardsViewHolder(private val binding: ItemCourseMapBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.Q)
        fun setBind(course: Course) {
            binding.apply {
                courseName.text = course.courseName
                distance.text = course.distance
                time.text = course.time
                bookmarkBtn.setOnClickListener {

                }
                root.setOnClickListener {
                    detailCourseListener.onClick(course = course)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardsViewHolder {
        binding = ItemCourseMapBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

class CoursesMapDiffCallback : DiffUtil.ItemCallback<Course>() {
    override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem.courseId == newItem.courseId
    }

    override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem == newItem
    }
}