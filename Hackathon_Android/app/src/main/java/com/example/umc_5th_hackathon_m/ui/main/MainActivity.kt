package com.example.umc_5th_hackathon_m.ui.main

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.umc_5th_hackathon_m.R
import com.example.umc_5th_hackathon_m.databinding.ActivityMainBinding
import com.example.umc_5th_hackathon_m.ui.main.community.CommunityFragment
import com.example.umc_5th_hackathon_m.ui.main.diary.DiaryFragment
import com.example.umc_5th_hackathon_m.ui.main.page.PageFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    private var isFabOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFabClickListener()

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, DiaryFragment())
            .commitAllowingStateLoss()
    }

    private fun setFabClickListener() {
        binding.mainFabMain.setOnClickListener {
            toggleFab()
        }
        binding.mainFab1.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, DiaryFragment())
                    .commitAllowingStateLoss()
        }
        binding.mainFab2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, CommunityFragment())
                .commitAllowingStateLoss()
        }
        binding.mainFab3.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, PageFragment())
                .commitAllowingStateLoss()
        }
    }

    private fun toggleFab() {
        if (isFabOpen) {
            ObjectAnimator.ofFloat(binding.mainFab1, "translationY", 0f).apply { start() }
            ObjectAnimator.ofFloat(binding.mainFab2, "translationY", 0f).apply { start() }
            ObjectAnimator.ofFloat(binding.mainFab3, "translationY", 0f).apply { start() }
            ObjectAnimator.ofFloat(binding.mainFabMain, View.ROTATION, 45f, 0f).apply { start() }
        } else { // 플로팅 액션 버튼 열기 - 닫혀있는 플로팅 버튼 꺼내는 애니메이션
            ObjectAnimator.ofFloat(binding.mainFab1, "translationY", -540f).apply { start() }
            ObjectAnimator.ofFloat(binding.mainFab2, "translationY", -360f).apply { start() }
            ObjectAnimator.ofFloat(binding.mainFab3, "translationY", -180f).apply { start() }
            ObjectAnimator.ofFloat(binding.mainFabMain, View.ROTATION, 0f, 45f).apply { start() }
        }

        isFabOpen = !isFabOpen
    }


}