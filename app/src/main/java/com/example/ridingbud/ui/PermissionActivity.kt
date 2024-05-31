package com.example.ridingbud.ui

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.ridingbud.databinding.AccessDialogBinding
import com.example.ridingbud.databinding.ActivityPermissionBinding
import com.example.ridingbud.ui.user.LoginActivity

class PermissionActivity : AppCompatActivity() {
    lateinit var binding: ActivityPermissionBinding
    private val REQUEST_PERMISSIONS = 1
    private val permissionList = mutableListOf(
        Manifest.permission.CAMERA,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION,
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUi()
        checkPermission()
    }

    private fun checkPermission() {
        var status = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissionList.add(Manifest.permission.READ_MEDIA_VIDEO)
            permissionList.add(Manifest.permission.READ_MEDIA_AUDIO)
            permissionList.add(Manifest.permission.READ_MEDIA_IMAGES)
            permissionList.add(Manifest.permission.POST_NOTIFICATIONS)
            permissionList.remove(Manifest.permission.READ_EXTERNAL_STORAGE)
            permissionList.remove(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        permissionList.forEach {
            if (ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_DENIED) {
                status = false
            }
        }

        if (status) {
            startActivity(Intent(this@PermissionActivity, LoginActivity::class.java))
            finish()
        }
    }

    private fun setUi() {
        val dialogBinding = AccessDialogBinding.inflate(layoutInflater)
        val dlg = Dialog(this)

        dialogBinding.apply {
            accessSettingBtn.setOnClickListener {
                requestMultiplePermissions.launch(permissionList.toTypedArray())
            }
            accessCancelBtn.setOnClickListener {
                dlg.dismiss()
            }
        }
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(dialogBinding.root)

        binding.apply {
            permissionBtn.setOnClickListener {
                dlg.show()
            }
        }
    }

    private val requestMultiplePermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { results ->
            results.forEach {
                if (!it.value) {
                    Toast.makeText(applicationContext, "${it.key} 권한 허용 필요", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            checkPermission()
        }
}