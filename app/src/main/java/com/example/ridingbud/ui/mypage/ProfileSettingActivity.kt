package com.example.ridingbud.ui.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.ridingbud.databinding.ActivityProfileSettingBinding
import com.example.ridingbud.viewmodel.ProfileSettingViewModel

class ProfileSettingActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileSettingBinding
    private val profileSettingViewModel: ProfileSettingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileSettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUi()
    }

    private fun setUi() {
        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }

            // 사용자 기본 정보 설정
//            profileSettingViewModel.profileInfo.observe(this@ProfileSettingActivity) {
//                // 프로필 사진 설정
//
//                // 닉네임 설정
//                nicknameSettingEt.setText(it.nickname)
//                // 이메일 설정
//                emailSettingEt.setText(it.email)
//                // 상태메세지 설정
//                statusSettingEt.setText(it.statusMessage)
//            }
            // 이미지 변경 기능
            imgSettingBtn.setOnClickListener {

            }
            imgSettingTitle.setOnClickListener {

            }
            // 닉네임 변경 기능
            nicknameSettingBtn.setOnClickListener {
                // 닉네임 변경 통신

                Toast.makeText(this.root.context,"닉네임이 변경되었습니다.",Toast.LENGTH_SHORT).show()
            }
            // 패스워드 변경 기능
            passwordSettingBtn.setOnClickListener {
                // 패스워드 변경 통신

            }
            // 이메일 변경 기능
            emailSettingBtn.setOnClickListener {
                // 이메일 변경 통신

                Toast.makeText(this.root.context,"이메일이 변경되었습니다.",Toast.LENGTH_SHORT).show()
            }
            // 상태메세지 변경 기능
            statusSettingBtn.setOnClickListener {
                // 상태메세지 변경 통신

                Toast.makeText(this.root.context,"상태메세지가 변경되었습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}