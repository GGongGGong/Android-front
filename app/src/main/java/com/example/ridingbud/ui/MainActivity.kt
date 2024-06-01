package com.example.ridingbud.ui

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.pm.Signature
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ridingbud.R
import com.example.ridingbud.databinding.ActivityMainBinding
import com.example.ridingbud.ui.community.CommunityFragment
import com.example.ridingbud.ui.convenience.ConvenienceFragment
import com.example.ridingbud.ui.mypage.MyPageFragment
import com.example.ridingbud.ui.riding.RidingFragment
import com.kakao.sdk.common.util.Utility
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 키 해시 구하기
//        Log.d("KeyHash", "${Utility.getKeyHash(this)}")
        setUi()
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0,0)
    }

    private fun setUi() {
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, RidingFragment()).commit()
        binding.bnv.setOnItemSelectedListener {item ->
            val transaction = supportFragmentManager.beginTransaction()
            when(item.itemId) {
                R.id.riding -> transaction.replace(R.id.fragment_container, RidingFragment())
                R.id.facility -> transaction.replace(R.id.fragment_container, ConvenienceFragment())
                R.id.community -> transaction.replace(R.id.fragment_container, CommunityFragment())
                R.id.mypage -> transaction.replace(R.id.fragment_container, MyPageFragment())
            }
            transaction.commit()
            true
        }
    }
}