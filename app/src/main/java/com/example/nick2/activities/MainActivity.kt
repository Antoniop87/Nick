package com.example.nick2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.nick2.R
import com.example.nick2.activities.videoAula.VideoAulaActivity
import com.example.nick2.activities.comunicacao.ComunicacaoActivity
import com.example.nick2.activities.jogos.JogosActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btn_jogos: LinearLayout
    private lateinit var btn_comunicacao: LinearLayout
    private lateinit var btn_video_aula: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        configuraButtons()

    }

    private fun initViews() {
        btn_jogos = findViewById(R.id.ll_jogos)
        btn_comunicacao = findViewById(R.id.ll_comunicacao)
        btn_video_aula = findViewById(R.id.ll_video_aula)
    }

    private fun configuraButtons() {

        btn_jogos.setOnClickListener {
            startActivity(Intent(this, JogosActivity::class.java))
        }

        btn_comunicacao.setOnClickListener {
            startActivity(Intent(this, ComunicacaoActivity::class.java))
        }

        btn_video_aula.setOnClickListener {
            startActivity(Intent(this, VideoAulaActivity::class.java))
        }

    }

}