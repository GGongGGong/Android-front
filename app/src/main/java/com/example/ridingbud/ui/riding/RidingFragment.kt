package com.example.ridingbud.ui.riding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ridingbud.databinding.FragmentRidingBinding
import com.example.ridingbud.model.Course
import com.example.ridingbud.ui.adapter.CoursesAdapter

class RidingFragment : Fragment() {
    lateinit var binding: FragmentRidingBinding
//    private val myProfileViewModel: MyProfileViewModel by viewModels()
    var courseData = mutableListOf(
        Course(0,"대구시내 근대골목 A코스","10 km","1 시간",5.0,false),
        Course(0,"대구시내 근대골목 B코스","9 km","1 시간",5.0,false),
        Course(0,"신천 금호강 상류 코스","15 km","2 시간",4.5,false)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRidingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        setUi()
    }

    override fun onResume() {
        super.onResume()
//        myProfileViewModel.getMyProfile()
    }

    private fun setAdapter() {
        // Adapter 설정
        val coursesAdapter = CoursesAdapter()
        coursesAdapter.detailCourseListener =
            object : CoursesAdapter.DetailCourseListener {
                override fun onClick(course: Course) {
                    // 코스 자세히 보기로 이동
//                    val intent = Intent(this@MyBookmarkListActivity, )
//                    intent.putExtra(ApplicationClass.COURSE_ITEM, course)
//                    startActivity(intent)
                }
            }
        // RecyclerView 설정
        binding.courseRv.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = coursesAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
        // RecyclerView Item 설정
        coursesAdapter.submitList(courseData)
//        myBookmarksViewModel.myCourses.observe(this) {
//            courseAdapter.submitList(it)
//        }
    }

    private fun setUi() {
        binding.apply {

        }
    }
}