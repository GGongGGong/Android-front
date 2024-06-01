package com.example.ridingbud.ui.community

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ridingbud.R
import com.example.ridingbud.databinding.ActivityCourseDetailBinding
import com.example.ridingbud.model.Course
import com.example.ridingbud.model.Review
import com.example.ridingbud.ui.adapter.ReviewAdapter
import com.google.android.gms.location.LocationServices
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.MapLifeCycleCallback
import com.kakao.vectormap.MapView
import com.kakao.vectormap.MapViewInfo
import com.kakao.vectormap.label.LabelOptions
import com.kakao.vectormap.label.LabelStyle
import com.kakao.vectormap.label.LabelStyles
import com.kakao.vectormap.route.RouteLineOptions
import com.kakao.vectormap.route.RouteLineSegment
import com.kakao.vectormap.route.RouteLineStyle
import com.kakao.vectormap.route.RouteLineStyles
import com.kakao.vectormap.route.RouteLineStylesSet
import java.util.Arrays

class CourseDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCourseDetailBinding
    private lateinit var mapView: MapView
    private lateinit var reviewAdapter: ReviewAdapter
    var courseData = mutableListOf(
        Course(0, "대구시내 근대골목 A코스", "10 km", "1 시간", 5.0, false),
        Course(0, "대구시내 근대골목 B코스", "9 km", "1 시간", 5.0, false),
        Course(0, "신천 금호강 상류 코스", "15 km", "2 시간", 4.5, true)
    )
    var markerPos = Arrays.asList(
        LatLng.from(35.87711, 128.5974),
        LatLng.from(35.87682, 128.6045),
        LatLng.from(35.87140, 128.6044),
        LatLng.from(35.86953, 128.6026),
        LatLng.from(35.87088, 128.5956),
        LatLng.from(35.87116, 128.5941),
        LatLng.from(35.86985, 128.5938),
        LatLng.from(35.86852, 128.5926),
        LatLng.from(35.86847, 128.5902),
        LatLng.from(35.86756, 128.5864),
        LatLng.from(35.86888, 128.5824),
        LatLng.from(35.86867, 128.5814),
        LatLng.from(35.87368, 128.5801),
        LatLng.from(35.87391, 128.5876),
        LatLng.from(35.87200, 128.5910),
        LatLng.from(35.87214, 128.596),
        LatLng.from(35.87491, 128.5959),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "코스 상세 정보"

        // Initialize MapView
        mapView = binding.mapView

        // Setup RecyclerView for reviews
        reviewAdapter = ReviewAdapter(getDummyReviews())
        binding.recyclerViewReviews.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewReviews.adapter = reviewAdapter

        // Write review button click listener
        binding.btnWriteReview.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }

        setKakaoMap()
    }

    override fun onResume() {
        super.onResume()
        mapView.resume()
    }

    override fun onPause() {
        super.onPause()
        mapView.pause()
    }



    @SuppressLint("MissingPermission")
    private fun setKakaoMap() {
        val locationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        // KakaoMap 설정
        binding.apply {
            mapView.start(
                object : MapLifeCycleCallback() {
                    override fun onMapDestroy() {
                        // 지도 API가 정상적으로 종료될 때 호출
                        Log.d("KakaoMap", "onMapDestroy: ")
                    }

                    override fun onMapError(error: Exception?) {
                        // 인증 실패 및 지도 사용 중 에러가 발생할 때 호출
                        Log.e("KakaoMap", "onMapError: ${error}")
                    }
                },
                object : KakaoMapReadyCallback() {
                    override fun onMapReady(map: KakaoMap) {
                        // 인증 후 API 가 정상적으로 실행될 때 호출됨
                        setRoute(map)
                        // 마커 설정
                        setMarker(map)
                        // 사용자의 현재 위치 버튼 기능

                    }

                    override fun getZoomLevel(): Int {
                        // 지도 시작 시 확대/축소 줌 레벨 설정
                        return super.getZoomLevel()
                    }

                    override fun getPosition(): LatLng {
                        // 지도 시작 시 위치 좌표를 설정
                        return LatLng.from(35.865486, 128.593359) // 대구시 반월당역
                    }

                    override fun getMapViewInfo(): MapViewInfo {
                        // 지도 시작 시 App 및 MapType 설정
                        return super.getMapViewInfo()
                    }
                })
        }
    }

    private fun getDummyReviews(): List<Review> {
        // Replace this with real data fetching logic
        return listOf(
            Review(1, "대구시내 근대골목 A코스", 4.5, "2022-01-01", "정말 좋은 코스입니다.", 12, "User1"),
            Review(2, "대구시내 근대골목 A코스", 4.0, "2022-02-01", "추천합니다.", 8, "User2")
        )
    }
    private fun setRoute(map: KakaoMap) {
        // 1. RouteLineLayer 가져오기
        val layer = map.routeLineManager?.getLayer()
        // 2. RouteLineStylesSet 생성
        var stylesSet = RouteLineStylesSet.from(
            "blueStyles",
            RouteLineStyles.from(RouteLineStyle.from(16F, Color.BLUE))
        )
        // 3. RouteLineSegment 생성
        // 세그먼트에 스타일 설정을 생략하면, RouteLineStylesSet 의 index 0 번째에 해당되는 스타일로 설정
        var segment = RouteLineSegment.from(
            markerPos
        ).setStyles(stylesSet.getStyles(0))
        // 4. RouteLineStylesSet 추가 및 RouteLineOptions 생성
        var options = RouteLineOptions.from(segment).setStylesSet(stylesSet)
        // 5. RouteLineLayer에 추가하여 RouteLine 생성
        var routeLine = layer?.addRouteLine(options)
        routeLine?.show()
    }

    private fun setMarker(map: KakaoMap) {
        var styles =
            map.labelManager?.addLabelStyles(LabelStyles.from(LabelStyle.from(R.drawable.marker_icon)))

        for (item in markerPos) {
            var options = LabelOptions.from(item).setStyles(styles)

            var layer = map.labelManager?.getLayer()

            var label = layer?.addLabel(options)
            label?.show()
        }
    }
}
