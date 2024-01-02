package com.youngseo3.lacuna.myapplication.ui.main.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.youngseo3.lacuna.myapplication.R
import com.youngseo3.lacuna.myapplication.databinding.FragmentWriteBinding
import com.youngseo3.lacuna.myapplication.ui.main.MainActivity

class WriteFragment : Fragment() {

    private lateinit var binding: FragmentWriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriteBinding.inflate(inflater, container, false)

        binding.activityWriteTopic1Btn.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key", binding.activityWriteTopic1Btn.text.toString())
            val writeContentFragment = WriteContentFragment()

            writeContentFragment.arguments = bundle

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.main_frm, writeContentFragment)
                .commit()

        }

        binding.activityWriteTopic2Btn.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key", binding.activityWriteTopic2Btn.text.toString())
            val writeContentFragment = WriteContentFragment()

            writeContentFragment.arguments = bundle

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.main_frm, writeContentFragment)
                .commit()

        }

        return binding.root
    }

}