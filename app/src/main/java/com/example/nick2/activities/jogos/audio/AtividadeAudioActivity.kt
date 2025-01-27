package com.example.nick2.activities.jogos.audio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import com.example.nick2.R
import com.example.nick2.adapter.MyGridAdapter
import com.example.nick2.model.Item

class AtividadeAudioActivity : AppCompatActivity() {

    lateinit var btn_fechar: ImageView
    lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividade_audio)
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
            Item("Nome das frutas", R.drawable.uva),
            Item("Nome dos animais", R.drawable.urso),
            Item("Nome das comidas", R.drawable.pao),
            Item("Nome dos objetos", R.drawable.livros),
        )

        val adapter = MyGridAdapter(this, items)
        gridView.adapter = adapter

        gridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val item = items[position]


                val intent = when (item.name) {
                    "Nome dos animais" -> Intent(this, AnimaisAudioActivity::class.java)
                    "Nome das comidas" -> Intent(this, ComidaAudioActivity::class.java)
                    "Nome dos objetos" -> Intent(this, ObjetosAudioActivity::class.java)
                    else -> Intent(this, NomeFrutaActivity::class.java)
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