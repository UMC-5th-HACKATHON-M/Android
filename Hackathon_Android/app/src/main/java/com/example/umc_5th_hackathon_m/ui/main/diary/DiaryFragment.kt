package com.example.umc_5th_hackathon_m.ui.main.diary

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.umc_5th_hackathon_m.R
import com.example.umc_5th_hackathon_m.databinding.FragmentDiaryBinding
import com.example.umc_5th_hackathon_m.ui.main.MainActivity
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import java.util.Calendar

class DiaryFragment : Fragment() {
    private lateinit var binding : FragmentDiaryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiaryBinding.inflate(inflater, container, false)

        calendar()
        clickListener()

        return binding.root
    }

    private fun calendar() {
        val materialCalendarView: MaterialCalendarView = binding.diaryCalendarview

        materialCalendarView.setOnDateChangedListener { widget, date, selected ->
            binding.diaryQuestionTv.visibility = View.VISIBLE
            binding.diaryCategoryCv.visibility = View.VISIBLE
            val selectedDate: Calendar = Calendar.getInstance()
            selectedDate.set(date.year, date.month, date.day)

            // 선택한 년도, 월, 일
            Log.d("Selected Date", "${selectedDate.get(Calendar.YEAR)}-${selectedDate.get(Calendar.MONTH)}-${selectedDate.get(Calendar.DAY_OF_MONTH)}")
        }
    }

    private fun clickListener() {
        binding.diaryCategoryCv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, DiaryCategoryFragment())
                .commitAllowingStateLoss()
        }
    }


}