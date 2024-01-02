package com.youngseo3.lacuna.myapplication.ui.main.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.youngseo3.lacuna.myapplication.R
import com.youngseo3.lacuna.myapplication.data.entities.BoardWrite
import com.youngseo3.lacuna.myapplication.databinding.FragmentCommunityBinding
import com.youngseo3.lacuna.myapplication.ui.main.MainActivity

class CommunityFragment : Fragment() {
    private lateinit var binding : FragmentCommunityBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityBinding.inflate(inflater, container, false)

        val itemList = ArrayList<BoardWrite>()
        itemList.add(BoardWrite("주제1","title1","content1"))
        itemList.add(BoardWrite("주제2","title2","content2"))
        itemList.add(BoardWrite("주제3","title3","content3"))

        val writingAdapter = WritingRVAdapter(itemList)
        writingAdapter.notifyDataSetChanged()
        binding.fragmentCommunityWritingRv.adapter = writingAdapter

        binding.fragmentCommunityWriteBtn.setOnClickListener {
            val mActivity = activity as MainActivity
            mActivity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_frm, WriteFragment())
                .commit()
            // 액티비티 전환
//            val intent = Intent(activity, WriteActivity::class.java)
//            startActivity(intent)
        }
        return binding.root

    }
}