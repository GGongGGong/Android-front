package com.example.ridingbud.ui.convenience

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.ridingbud.R
import com.example.ridingbud.databinding.FragmentConvenienceBinding
import com.google.android.gms.location.LocationServices
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.MapLifeCycleCallback
import com.kakao.vectormap.MapView
import com.kakao.vectormap.label.LabelOptions
import com.kakao.vectormap.label.LabelStyle
import com.kakao.vectormap.label.LabelStyles

class ConvenienceFragment : Fragment() {

    private var _binding: FragmentConvenienceBinding? = null
    private val binding get() = _binding!!
    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConvenienceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize MapView
        mapView = MapView(requireContext())
        binding.mapViewContainer.addView(mapView)

        // Set up map and add labels when ready
        mapView.start(object : MapLifeCycleCallback() {
            override fun onMapDestroy() {
                // Called when the map API is properly terminated
                Log.d("KakaoMap", "onMapDestroy")
            }

            override fun onMapError(error: Exception) {
                // Called when an error occurs while using the map
                Log.e("KakaoMap", "onMapError: ${error.message}")
            }
        }, object : KakaoMapReadyCallback() {
            override fun onMapReady(kakaoMap: KakaoMap) {
                // Called when the map API is properly authenticated and ready

                // Define a unique layerId
                val layerId = "myCustomLayer"

                // Create LabelStyles with an icon image
                val styles =
                    kakaoMap.labelManager?.addLabelStyles(LabelStyles.from(LabelStyle.from(R.drawable.marker_icon)))

                // Create LabelOptions with the coordinates and styles
                val options = LabelOptions.from(LatLng.from(35.87491, 128.5959)).setStyles(styles)

                // Get LabelLayer with layerId (or create custom Layer)
                val layer = kakaoMap.labelManager?.layer

                // Add Label to LabelLayer
                layer?.addLabel(options)?.show()

                // Handle user's current location
                binding.btnCurrentLocation.setOnClickListener {
                    getCurrentLocationAndAddLabel(kakaoMap)
                }
            }
        })
    }


    private fun getCurrentLocationAndAddLabel(kakaoMap: KakaoMap) {
        val locationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), 1)
            return
        }

        locationProviderClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                location?.let {
                    val styles =
                        kakaoMap.labelManager?.addLabelStyles(LabelStyles.from(LabelStyle.from(R.drawable.user_location_icon)))
                    val options =
                        LabelOptions.from(LatLng.from(it.latitude, it.longitude)).setStyles(styles)
                    val layer = kakaoMap.labelManager?.getLayer()
                    layer?.addLabel(options)?.show()

                    // Move camera to user's current location
                    kakaoMap.moveCamera(
                        com.kakao.vectormap.camera.CameraUpdateFactory.newCenterPosition(
                            LatLng.from(it.latitude, it.longitude)
                        )
                    )
                }
            }
            .addOnFailureListener { exception ->
                Log.e("LocationError", exception.localizedMessage ?: "Location fetch failed")
            }
    }

    override fun onResume() {
        super.onResume()
        mapView.resume()  // Call resume on MapView
    }

    override fun onPause() {
        super.onPause()
        mapView.pause()  // Call pause on MapView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.mapViewContainer.removeView(mapView)
        _binding = null
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }
}
