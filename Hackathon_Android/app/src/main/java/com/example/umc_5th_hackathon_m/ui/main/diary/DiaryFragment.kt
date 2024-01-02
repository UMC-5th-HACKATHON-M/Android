package com.example.umc_5th_hackathon_m.ui.main.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.umc_5th_hackathon_m.databinding.FragmentDiaryBinding
import com.prolificinteractive.materialcalendarview.MaterialCalendarView

class DiaryFragment : Fragment() {
    private lateinit var binding : FragmentDiaryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiaryBinding.inflate(inflater, container, false)
        calendar()
        return binding.root
    }

    private fun calendar() {
        val materialCalendarView: MaterialCalendarView = binding.diaryCalendarview

        materialCalendarView.setOnDateChangedListener { widget, date, selected ->
            binding.diaryQuestionTv.visibility = View.VISIBLE
            binding.diaryCategoryCv.visibility = View.VISIBLE
        }
    }


}