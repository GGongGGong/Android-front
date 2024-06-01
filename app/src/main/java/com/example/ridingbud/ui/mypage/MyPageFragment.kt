package com.example.ridingbud.ui.mypage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ridingbud.ApplicationClass.Companion.sharedPreferencesUtil
import com.example.ridingbud.databinding.FragmentMyprofileBinding
import com.example.ridingbud.ui.user.LoginActivity
import com.example.ridingbud.viewmodel.MyProfileViewModel
import com.kakao.sdk.user.UserApiClient

class MyPageFragment : Fragment() {
    lateinit var binding: FragmentMyprofileBinding
    private val myProfileViewModel: MyProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyprofileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUi()
    }

    override fun onResume() {
        super.onResume()
//        myProfileViewModel.getMyProfile()
    }

    private fun setUi() {
        binding.apply {
            // 프로필 설정
//            myProfileViewModel.profileInfo.observe(viewLifecycleOwner) { profileInfo ->
//                // 프로필 사진 설정
//
//                // 닉네임 설정
//                nickname.text = profileInfo.nickname
//                // 상태메세지 설정
//                status.text = profileInfo.statusMessage
//            }
            // 포리필 편집 기능
            profileBox.setOnClickListener {
                startActivity(Intent(activity, ProfileSettingActivity::class.java))
            }
            settingBtn.setOnClickListener {
                startActivity(Intent(activity, ProfileSettingActivity::class.java))
            }
            // 즐겨찾기 코스 목록 기능
            bookmarkBox.setOnClickListener {
                startActivity(Intent(activity, MyBookmarkListActivity::class.java))
            }
            bookmarkMoreBtn.setOnClickListener {
                startActivity(Intent(activity, MyBookmarkListActivity::class.java))
            }
            // 나의 리뷰 목록 기능
            reviewNum.text = "5개"
            reviewBox.setOnClickListener {
                startActivity(Intent(activity, MyReviewListActivity::class.java))
            }
            reviewMoreBtn.setOnClickListener {
                startActivity(Intent(activity, MyReviewListActivity::class.java))
            }
            // 오픈 소스 라이센스
            licenseMoreBtn.setOnClickListener {

            }
            // 앱 버전
            appVersionNum.text = "0.0.0v"

            // 로그아웃
            logoutBtn.setOnClickListener {
                // Kakao SDK 토큰 삭제
                UserApiClient.instance.logout { error ->
                    if (error != null) {
                        Log.d("Logout", "로그아웃 실패. SDK에서 토큰 삭제됨", error)
                    }
                    else {
                        Log.d("Logout", "로그아웃 성공. SDK에서 토큰 삭제됨")
                    }
                }
                // 로그인 토큰 삭제
                sharedPreferencesUtil.deleteToken()
                // 로그인 화면 이동
                startActivity(Intent(activity, LoginActivity::class.java))
                activity?.finish()
            }
        }
    }
}