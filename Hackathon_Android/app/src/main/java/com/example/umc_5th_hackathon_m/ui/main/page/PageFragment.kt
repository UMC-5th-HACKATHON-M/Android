package com.example.umc_5th_hackathon_m.ui.main.page

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.umc_5th_hackathon_m.R
import com.example.umc_5th_hackathon_m.databinding.FragmentPageBinding
import com.example.umc_5th_hackathon_m.databinding.FragmentPageLogoutBinding

class PageFragment : Fragment() {
    private lateinit var binding : FragmentPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 로그아웃 버튼에 대한 클릭 이벤트 처리
        binding.logoutButton.setOnClickListener {
            showLogoutConfirmationDialog()
        }

        // 기타 초기화 코드 등...
    }


    private fun showLogoutConfirmationDialog() {
        val dialogView =
            LayoutInflater.from(requireContext()).inflate(R.layout.fragment_page_logout, null)
        val customDialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()

        val bodyTextView = dialogView.findViewById<TextView>(R.id.bodyTextView)
        val positiveButton = dialogView.findViewById<Button>(R.id.positiveButton)
        val negativeButton = dialogView.findViewById<Button>(R.id.negativeButton)


        bodyTextView.text = "로그아웃 하시겠습니까?"

        positiveButton.setOnClickListener {
            // 확인 버튼을 눌렀을 때의 동작
            customDialog.dismiss()
        }

        negativeButton.setOnClickListener {
            // 취소 버튼을 눌렀을 때의 동작
            customDialog.dismiss()
        }

        customDialog.show()
    }



}