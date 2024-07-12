package com.example.nick2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.Toast
import com.example.nick2.R
import com.example.nick2.activities.comunicacao.ComunicacaoActivity
import com.example.nick2.adapter.MyGridAdapter
import com.example.nick2.model.Item

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
            Toast.makeText(this@MainActivity, "video aula", Toast.LENGTH_SHORT).show()
        }

    }

}