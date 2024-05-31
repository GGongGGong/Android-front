package com.example.ridingbud.ui.user

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.ridingbud.databinding.ActivityFindPasswordBinding
import com.example.ridingbud.databinding.ActivityLoginBinding

class FindPasswordActivity : AppCompatActivity() {
    lateinit var binding: ActivityFindPasswordBinding
//    private val logInViewModel: LogInViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUi()
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0,0)
    }

    private fun setUi() {
//        logInViewModel.token.observe(this){
//            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//            finish()
//        }
        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }
            findPasswordBtn.setOnClickListener {
                finish()
            }
        }
    }
}