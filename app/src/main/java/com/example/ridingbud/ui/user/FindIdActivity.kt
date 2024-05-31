package com.example.ridingbud.ui.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ridingbud.databinding.ActivityFindIdBinding

class FindIdActivity : AppCompatActivity() {
    lateinit var binding: ActivityFindIdBinding
//    private val logInViewModel: LogInViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindIdBinding.inflate(layoutInflater)
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
            findIdBtn.setOnClickListener {
                finish()
            }
        }
    }
}