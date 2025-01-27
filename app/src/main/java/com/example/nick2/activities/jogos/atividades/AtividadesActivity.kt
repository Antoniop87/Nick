package com.example.nick2.activities.jogos.atividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import com.example.nick2.R
import com.example.nick2.activities.jogos.AcerteAFrutaActivity
import com.example.nick2.activities.jogos.audio.NomeFrutaActivity
import com.example.nick2.activities.jogos.SomaActivity
import com.example.nick2.adapter.MyGridAdapter
import com.example.nick2.model.Item

//essa activity lista as atividades
class AtividadesActivity : AppCompatActivity() {

    lateinit var btn_fechar: ImageView
    lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividades)
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
            Item("O que o animal come?", R.drawable.uva),
            Item("Conhecendo os animais", R.drawable.leao),
            Item("Cores", R.drawable.paleta),
            Item("Formas", R.drawable.formas),
        )

        val adapter = MyGridAdapter(this, items)
        gridView.adapter = adapter

        gridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val item = items[position]


                val intent = when (item.name) {
                    "Cores" -> Intent(this, CoresActivity::class.java)
                    "Conhecendo os animais" -> Intent(this, SobreAnimaisActivity::class.java)
                    "O que o animal come?" -> Intent(this, AtividadeActivity::class.java)
                    "Formas" -> Intent(this, FormasActivity::class.java)
                    else -> Intent(this, FormasActivity::class.java)
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