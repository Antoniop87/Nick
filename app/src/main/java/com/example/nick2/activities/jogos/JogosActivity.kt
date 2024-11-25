package com.example.nick2.activities.jogos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import com.example.nick2.R
import com.example.nick2.adapter.MyGridAdapter
import com.example.nick2.model.Item

class JogosActivity : AppCompatActivity() {

    lateinit var btn_fechar: ImageView
    lateinit var gridView: GridView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogos)
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
            Item("Acerte a fruta", R.drawable.uva),
            Item("Soma", R.drawable.numero_tres),
            Item("Comida", R.drawable.capa_macaco),
            Item("Teste", R.drawable.eu_quero),
        )

        val adapter = MyGridAdapter(this, items)
        gridView.adapter = adapter

        gridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val item = items[position]


                val intent = when (item.name) {
                    "Acerte a fruta" -> Intent(this, AcerteAFrutaActivity::class.java)
                    "Soma" -> Intent(this, SomaActivity::class.java)
                    "Teste" -> Intent(this, AtividadeActivity::class.java)
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