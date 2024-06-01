package com.example.ridingbud.ui.community

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ridingbud.databinding.ActivityCourseDetailBinding
import com.example.ridingbud.model.Review
import com.example.ridingbud.ui.adapter.ReviewAdapter
import com.kakao.vectormap.MapView
class CourseDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCourseDetailBinding
    private lateinit var mapView: MapView
    private lateinit var reviewAdapter: ReviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "코스 상세 정보"

        // Initialize MapView
        mapView = MapView(this)
        binding.mapViewContainer.addView(mapView)

        // Setup RecyclerView for reviews
        reviewAdapter = ReviewAdapter(getDummyReviews())
        binding.recyclerViewReviews.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewReviews.adapter = reviewAdapter

        // Write review button click listener
        binding.btnWriteReview.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.resume()
    }

    override fun onPause() {
        super.onPause()
        mapView.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapViewContainer.removeView(mapView)
        mapView.destroyDrawingCache()
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    private fun getDummyReviews(): List<Review> {
        // Replace this with real data fetching logic
        return listOf(
            Review(1, "대구시내 근대골목 A코스", 4.5, "2022-01-01", "정말 좋은 코스입니다.", 12, "User1"),
            Review(2, "대구시내 근대골목 A코스", 4.0, "2022-02-01", "추천합니다.", 8, "User2")
        )
    }
}
