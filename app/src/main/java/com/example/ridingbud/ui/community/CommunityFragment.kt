package com.example.ridingbud.ui.community

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ridingbud.R
import com.example.ridingbud.databinding.FragmentCommunityBinding
import com.example.ridingbud.model.Course
import com.example.ridingbud.ui.adapter.CourseAdapter

class CommunityFragment : Fragment(), CourseAdapter.OnItemClickListener {

    private var _binding: FragmentCommunityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommunityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Hot Course RecyclerView 설정
        val hotCourseAdapter = CourseAdapter(getHotCourses(), this)
        binding.hotCoursesRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.hotCoursesRecyclerView.adapter = hotCourseAdapter

        // Course RecyclerView 설정
        val courseAdapter = CourseAdapter(getCourses(), this)
        binding.courseRv.layoutManager = LinearLayoutManager(context)
        binding.courseRv.adapter = courseAdapter
    }

    private fun getHotCourses(): List<Course> {
        // Hot Courses 데이터를 반환합니다.
        return listOf(
            Course(1, "대구시내 근대골목 A 코스", "10 km", "1 시간", 5.0, false),
            Course(2, "대구시내 근대골목 B 코스", "9 km", "1 시간", 5.0, false)
            // 추가 데이터 필요
        )
    }

    private fun getCourses(): List<Course> {
        // Courses 데이터를 반환합니다.
        return listOf(
            Course(1, "대구시내 근대골목 A 코스", "10 km", "1 시간", 5.0, false),
            Course(2, "대구시내 근대골목 B 코스", "9 km", "1 시간", 5.0, false),
            Course(3, "신천 금호강 상류 코스", "15 km", "2 시간", 4.8, false),
            Course(4, "강정고령보 달성보 코스", "21 km", "11 시간", 4.2, false)
            // 추가 데이터 필요
        )
    }

    override fun onItemClick(course: Course) {
        val intent = Intent(context, CourseDetailActivity::class.java).apply {
            putExtra("courseId", course.courseId)
            putExtra("courseName", course.courseName)
            putExtra("courseDistance", course.distance)
            putExtra("courseDuration", course.time)
            putExtra("courseRating", course.rate)
        }
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}