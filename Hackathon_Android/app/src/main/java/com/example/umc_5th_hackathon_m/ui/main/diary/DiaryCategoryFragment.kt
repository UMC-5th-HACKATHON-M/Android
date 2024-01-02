package com.example.umc_5th_hackathon_m.ui.main.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_5th_hackathon_m.R
import com.example.umc_5th_hackathon_m.databinding.FragmentDiaryCategoryBinding
import com.example.umc_5th_hackathon_m.ui.main.MainActivity

class DiaryCategoryFragment : Fragment() {
    private lateinit var binding : FragmentDiaryCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiaryCategoryBinding.inflate(inflater, container, false)

        clickListener()

        return binding.root
    }

    private fun clickListener() {
        binding.categoryBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, DiaryFragment())
                .commitAllowingStateLoss()
        }
    }
}