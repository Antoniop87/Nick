package com.example.nick2.activities.videoAula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import com.example.nick2.R

class ExibeVideoAulaActivity : AppCompatActivity() {

    private lateinit var wv_exibe_video: WebView
    private lateinit var btn_fechar: ImageView
    private lateinit var tv_titulo: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibe_video_aula)
        initView()
        configuraWebView()
        configuraButtons()
        configuraTitulo()
    }

    private fun initView(){
        wv_exibe_video = findViewById(R.id.wv_exibe_video)
        btn_fechar = findViewById(R.id.btn_fechar)
        tv_titulo = findViewById(R.id.tv_titulo_video_aula)
    }

    private fun configuraWebView(){
        val video = intent.getStringExtra("VIDEO_AULA").toString()

        wv_exibe_video.loadData(video, "text/html", "utf-8")
        wv_exibe_video.settings.javaScriptEnabled = true
        wv_exibe_video.webChromeClient = WebChromeClient()
    }

    private fun configuraButtons(){
        btn_fechar.setOnClickListener {
            finish()
        }
    }

    private fun configuraTitulo(){
        val titulo: String = intent.getStringExtra("TITULO").toString()
        tv_titulo.setText(titulo)
    }

}