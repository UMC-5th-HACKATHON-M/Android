package com.youngseo3.lacuna.myapplication.ui.main.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.youngseo3.lacuna.myapplication.databinding.FragmentDiaryBinding

class DiaryFragment : Fragment() {
    private lateinit var binding : FragmentDiaryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiaryBinding.inflate(inflater, container, false)
        return binding.root
    }
}