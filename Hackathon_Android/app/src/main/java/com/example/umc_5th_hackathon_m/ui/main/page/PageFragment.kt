package com.example.umc_5th_hackathon_m.ui.main.page

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_5th_hackathon_m.databinding.FragmentPageBinding

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
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("로그아웃")
            .setMessage("로그아웃하시겠습니까?")
            .setPositiveButton("확인") { dialog: DialogInterface, which: Int ->
                // 여기에 로그아웃 처리 코드 추가
                // 예: 로그아웃 메서드 호출 또는 세션 초기화 등
                // 예: FirebaseAuth.getInstance().signOut() // Firebase 사용 시 로그아웃
                dialog.dismiss()
            }
            .setNegativeButton("취소") { dialog: DialogInterface, which: Int ->
                // 취소 버튼을 눌렀을 때의 동작 (아무 것도 안해도 됨)
                dialog.dismiss()
            }
            .show()
    }




}