package com.example.nick2.activities.comunicacao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import com.example.nick2.R
import com.example.nick2.activities.comunicacao.diaadia.DiaADiaActivity
import com.example.nick2.activities.comunicacao.emocoes.EmocoesActivity
import com.example.nick2.adapter.MyGridAdapterAComunicacao
import com.example.nick2.model.ItemAudio

class ComunicacaoActivity : AppCompatActivity() {

    lateinit var gridView: GridView
    lateinit var btn_fechar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comunicacao)
        initViews()
        configuraGridView()
        configuraButons()
    }

    private fun initViews() {
        gridView = findViewById(R.id.gridView)
        btn_fechar = findViewById(R.id.btn_fechar)
    }

    private fun configuraGridView() {
        val items = listOf(
            ItemAudio("Dia a dia", R.drawable.hi, R.raw.p_24973253_312),
            ItemAudio("Emoções", R.drawable.pai, R.raw.p_24973272_337),

        )

        val adapter = MyGridAdapterAComunicacao(this, items)
        gridView.adapter = adapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val item = items[position]


            val intent = when (item.name) {
                "Dia a dia" -> Intent(this, DiaADiaActivity::class.java)
                else -> Intent(this, EmocoesActivity::class.java)
            }

            startActivity(intent)
        }
    }

    private fun configuraButons(){
        btn_fechar.setOnClickListener {
            finish()
        }
    }

}