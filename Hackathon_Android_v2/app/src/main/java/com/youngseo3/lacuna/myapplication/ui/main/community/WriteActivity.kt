//package com.youngseo3.lacuna.myapplication.ui.main.community
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.youngseo3.lacuna.myapplication.R
//import com.youngseo3.lacuna.myapplication.databinding.ActivityWriteBinding
//
//class WriteActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityWriteBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityWriteBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.activityWriteTopic1Btn.setOnClickListener{
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.write_frm, WriteContentFragment())
//                .commit()
//        }
//        binding.activityWriteTopic2Btn.setOnClickListener{
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.write_frm, WriteContentFragment())
//                .commit()
//        }
//    }
//}