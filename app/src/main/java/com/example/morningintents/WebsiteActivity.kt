package com.example.morningintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebsiteActivity : AppCompatActivity() {
    lateinit var mWebsite:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_website)
        mWebsite = findViewById(R.id.mWeb)
        var webSettings = mWebsite.settings
        webSettings.javaScriptEnabled = true
        mWebsite.loadUrl("https://www.emobilis.ac.ke")

    }
}