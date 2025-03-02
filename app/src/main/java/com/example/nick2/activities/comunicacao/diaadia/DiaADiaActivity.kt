package com.example.nick2.activities.comunicacao.diaadia

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import com.example.nick2.R
import com.example.nick2.adapter.MyGridAdapterAComunicacao
import com.example.nick2.model.ItemAudio

class DiaADiaActivity : AppCompatActivity() {

    lateinit var gridView: GridView
    lateinit var btn_fechar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dia_adia)
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
            ItemAudio("Eu quero", R.drawable.eu_quero, R.raw.p_24973571_697),
            ItemAudio("Não quero", R.drawable.nao_quero, R.raw.p_24973564_689),
            ItemAudio("Pegue", R.drawable.pegue, R.raw.p_40435784_140),
            ItemAudio("Bom", R.drawable.legal2semfundo, R.raw.p_40435804_166),
            ItemAudio("Gostei", R.drawable.gostei, R.raw.p_40435766_119),
            ItemAudio("Faço", R.drawable.faco, R.raw.p_40435792_153),

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