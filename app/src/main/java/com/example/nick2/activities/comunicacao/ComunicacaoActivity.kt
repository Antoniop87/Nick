package com.example.nick2.activities.comunicacao

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import com.example.nick2.R
import com.example.nick2.activities.jogos.AcerteAFrutaActivity
import com.example.nick2.activities.jogos.NomeFrutaActivity
import com.example.nick2.activities.jogos.SomaActivity
import com.example.nick2.adapter.MyGridAdapter
import com.example.nick2.adapter.MyGridAdapterAComunicacao
import com.example.nick2.model.Item
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
            ItemAudio("Oi", R.drawable.hi, R.raw.p_24973253_312),
            ItemAudio("Papai", R.drawable.pai, R.raw.p_24973272_337),
            ItemAudio("Abraço", R.drawable.abraco, R.raw.p_24973554_670),
            ItemAudio("Mãe", R.drawable.mae, R.raw.p_24973547_660),
            ItemAudio("Eu quero", R.drawable.eu_quero, R.raw.p_24973571_697),
            ItemAudio("Não quero", R.drawable.nao_quero, R.raw.p_24973564_689),

        )

        val adapter = MyGridAdapterAComunicacao(this, items)
        gridView.adapter = adapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val item = items[position]

            // Inicializar o MediaPlayer com o arquivo de áudio correspondente
            val mediaPlayer = MediaPlayer.create(this, item.audioResId)
            mediaPlayer.start()

            // Configurar o MediaPlayer para liberar os recursos após a conclusão da reprodução
            mediaPlayer.setOnCompletionListener {
                it.release()
            }
        }
    }

    private fun configuraButons(){
        btn_fechar.setOnClickListener {
            finish()
        }
    }

}