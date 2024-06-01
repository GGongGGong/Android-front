package com.example.ridingbud.ui.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ridingbud.databinding.FragmentCommunityBinding
import com.example.ridingbud.model.CourseItem
import com.example.ridingbud.ui.adapter.CoursesAdapter
import com.example.ridingbud.ui.adapter.HotCoursesAdapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.ridingbud.R

class CommunityFragment : Fragment() {

    private var _binding: FragmentCommunityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommunityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView for hot courses
        val hotCoursesAdapter = HotCoursesAdapter(getHotCourses())
        binding.hotCoursesRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.hotCoursesRecyclerView.adapter = hotCoursesAdapter

        // Setup Spinner for filter options
        val filterOptions = resources.getStringArray(R.array.filter_options)
        val spinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, filterOptions)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.filterSpinner.adapter = spinnerAdapter

        // Setup RecyclerView for course list
//        val coursesAdapter = CoursesAdapter(getCourses("초급 목록"))
//        binding.coursesRecyclerView.layoutManager = LinearLayoutManager(context)
//        binding.coursesRecyclerView.adapter = coursesAdapter

        // Spinner item selected listener
        binding.filterSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedCategory = parent.getItemAtPosition(position).toString()
                val filteredCourses = getCourses(selectedCategory)
//                coursesAdapter.updateCourses(filteredCourses)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
    }

    private fun getHotCourses(): List<CourseItem> {
        // Fetch or create hot course data
        return listOf(
            CourseItem("대구시내 근대골목 A코스", "10 km", "1시간", 5.0),
            CourseItem("대구시내 근대골목 B코스", "9 km", "1시간", 5.0)
        )
    }

    private fun getCourses(category: String): List<CourseItem> {
        // Fetch or create course list data based on category
        return when (category) {
            "초급 목록" -> listOf(
                CourseItem("대구시내 근대골목 A코스", "10 km", "1시간", 5.0),
                CourseItem("대구시내 근대골목 B코스", "9 km", "1시간", 5.0)
            )
            "중급 목록" -> listOf(
                CourseItem("신천 금호강 상류 코스", "15 km", "2시간", 4.8)
            )
            "상급 목록" -> listOf(
                CourseItem("강정고령보 달성보 코스", "21 km", "11시간", 4.2)
            )
            "즐겨찾기 목록" -> listOf(
                CourseItem("대구시내 근대골목 A코스", "10 km", "1시간", 5.0)
            )
            else -> emptyList()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}