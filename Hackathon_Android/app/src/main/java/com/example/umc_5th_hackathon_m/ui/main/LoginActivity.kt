package com.example.umc_5th_hackathon_m.ui.main

import android.R

import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

import androidx.appcompat.app.AppCompatActivity
import com.example.umc_5th_hackathon_m.databinding.ActivityLoginBinding



class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    private val apiUrl = "https://www.docker-ecs.net/login/kakao"
    private val redirectUri ="https://localhost:3000"
    private lateinit var webView: WebView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("userPrefs", MODE_PRIVATE)
        webView = binding.webView
        setupWebView()

        binding.kakaoLogin.setOnClickListener {
            webView.visibility = WebView.VISIBLE
            webView.loadUrl(apiUrl)
        }


        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(
                view: WebView?,
                url: String?,
                favicon: android.graphics.Bitmap?
            ) {
                super.onPageStarted(view, url, favicon)

                // 리디렉션된 URL에서 토큰 추출
                extractTokenFromRedirectUrl(url)
            }
        }
    }
        private fun extractTokenFromRedirectUrl(url: String?) {
            if (url != null && url.startsWith(redirectUri)) {
                // 리디렉션된 URL에서 토큰 추출 및 처리
                val token = extractTokenFromUrl(url)

                // 추출한 토큰을 저장 또는 활용
                if (token.isNotEmpty()) {
                    // TODO: 토큰 저장 또는 활용
                    sharedPreferences.edit().putString("accessToken", token).apply()
                }

                // 웹뷰 숨기기 또는 종료
                webView.visibility = WebView.GONE
            }
        }

        private fun extractTokenFromUrl(url: String): String {
            // URL에서 토큰 추출 로직을 구현
            // 예를 들어, URL 파라미터에서 토큰 추출
            val uri = Uri.parse(url)
            return uri.getQueryParameter("access_token") ?: ""
        }



    private fun setupWebView() {
        webView.settings.javaScriptEnabled = true
        webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        webView.clearCache(true)


    }


}



