package com.example.nick2.activities.jogos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.nick2.R
import com.example.nick2.activities.jogos.atividades.AtividadesActivity
import com.example.nick2.activities.jogos.audio.AtividadeAudioActivity
import com.example.nick2.adapter.MyGridAdapter
import com.example.nick2.model.Item

class JogosActivity : AppCompatActivity() {

    lateinit var btn_fechar: ImageView
    lateinit var ll_fala: LinearLayout
    lateinit var ll_atividades: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogos)
        initViews()
        configuraButons()

    }

    private fun initViews() {
        btn_fechar = findViewById(R.id.btn_fechar)
        ll_fala = findViewById(R.id.ll_fala)
        ll_atividades = findViewById(R.id.ll_atividades)
    }

    private fun configuraButons(){
        btn_fechar.setOnClickListener {
            finish()
        }

        ll_fala.setOnClickListener {
            val i = Intent(this, AtividadeAudioActivity::class.java)
            startActivity(i)
        }

        ll_atividades.setOnClickListener {
            val i = Intent(this, AtividadesActivity::class.java)
            startActivity(i)
        }
    }

}