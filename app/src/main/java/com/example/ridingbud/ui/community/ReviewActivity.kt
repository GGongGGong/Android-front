package com.example.ridingbud.ui.community

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ridingbud.R
import com.example.ridingbud.databinding.ActivityReviewBinding
import com.kakao.vectormap.MapView

class ReviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReviewBinding
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "리뷰 수정 및 작성"

        // Initialize MapView
        mapView = MapView(this)
        binding.mapViewContainer.addView(mapView)

        // Submit Button click listener
        binding.btnSubmitReview.setOnClickListener {
            val rating = binding.ratingBar.rating
            val reviewContent = binding.etReviewContent.text.toString()

            if (reviewContent.isNotBlank()) {
                // Handle review submission
                Toast.makeText(this, "리뷰가 제출되었습니다.", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "리뷰 내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
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
}
