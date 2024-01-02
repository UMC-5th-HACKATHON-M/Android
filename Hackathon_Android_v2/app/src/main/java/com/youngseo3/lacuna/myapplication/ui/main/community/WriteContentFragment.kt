package com.youngseo3.lacuna.myapplication.ui.main.community

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.setFragmentResultListener
import com.youngseo3.lacuna.myapplication.R
import com.youngseo3.lacuna.myapplication.data.entities.BoardWrite
import com.youngseo3.lacuna.myapplication.data.network.getRetrofit
import com.youngseo3.lacuna.myapplication.data.remote.BoardWriteInterface
import com.youngseo3.lacuna.myapplication.data.remote.BoardWriteResponse
import com.youngseo3.lacuna.myapplication.databinding.FragmentPageBinding
import com.youngseo3.lacuna.myapplication.databinding.FragmentWriteContentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WriteContentFragment : Fragment() {

    private lateinit var binding : FragmentWriteContentBinding
    private lateinit var result: String
//    override fun onCreate(savedInstanceState: Bundle?) {
//        // Use the Kotlin extension in the fragment-ktx artifact
//        setFragmentResultListener("requestKey") { key, bundle ->
//            // We use a String here, but any type that can be put in a Bundle is supported
//            result = bundle.getString("bundlekey")?: ""
//            // Do something with the result...
//        }
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val result = arguments?.getString("key")

        binding = FragmentWriteContentBinding.inflate(inflater, container, false)

        binding.fragmentWriteContentTopicTv.text = result
        val topic = binding.fragmentWriteContentTopicTv.text.toString()
        val title = binding.fragmentWriteContentTitleEt.text.toString()
        val content = binding.fragmentWriteContentContentEt.text.toString()

        // Retrofit 객체와 Service 객체를 생성, API 호출
        val authService = getRetrofit().create(BoardWriteInterface::class.java)

        binding.fragmentWriteContentWriteBtn.setOnClickListener {
            authService.boardWrite(BoardWrite(topic, title, content)).enqueue(object: Callback<BoardWriteResponse> {
                override fun onResponse(call: Call<BoardWriteResponse>, response: Response<BoardWriteResponse>) {
                    val resp: BoardWriteResponse = response.body()!!
                    Log.d("RESPONSE/SUCCESS", resp.toString())
                    when(resp.code) {
                        "200"->  Log.d("BOARDWRITE/SUCCESS", response.toString())
//                        "200"-> Toast.makeText(activity, "성공", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<BoardWriteResponse>, t: Throwable) {
                    Log.d("BOARDWRITE/FAILURE", t.message.toString())
                }
            })
        }

        return binding.root
    }
}