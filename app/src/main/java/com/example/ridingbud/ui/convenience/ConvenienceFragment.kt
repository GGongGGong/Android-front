package com.example.ridingbud.ui.convenience

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.ridingbud.databinding.FragmentConvenienceBinding
import com.kakao.vectormap.MapView

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

        // Current Location Button
        binding.btnCurrentLocation.setOnClickListener {
            moveToCurrentLocation()
        }

        // Other Buttons
        binding.btnOption1.setOnClickListener {
            Toast.makeText(requireContext(), "Option 1 clicked", Toast.LENGTH_SHORT).show()
        }

        binding.btnOption2.setOnClickListener {
            Toast.makeText(requireContext(), "Option 2 clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun moveToCurrentLocation() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), 1)
            return
        }

        // mapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == 1) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                moveToCurrentLocation()
            } else {
                Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_SHORT).show()
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

    override fun onDestroyView() {
        super.onDestroyView()
        binding.mapViewContainer.removeView(mapView)
        mapView.destroyDrawingCache()
        _binding = null
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }
}
