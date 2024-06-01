package com.example.ridingbud.ui.convenience

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.ridingbud.databinding.ActivityConvenienceBinding
import com.kakao.vectormap.MapView

class ConvenienceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConvenienceBinding
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConvenienceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize MapView
        mapView = MapView(this)
        binding.mapViewContainer.addView(mapView)

        // Current Location Button
        binding.btnCurrentLocation.setOnClickListener {
            moveToCurrentLocation()
        }

        // Other Buttons
        binding.btnOption1.setOnClickListener {
            Toast.makeText(this, "Option 1 clicked", Toast.LENGTH_SHORT).show()
        }

        binding.btnOption2.setOnClickListener {
            Toast.makeText(this, "Option 2 clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun moveToCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), 1)
            return
        }


        //mapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                moveToCurrentLocation()
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
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
