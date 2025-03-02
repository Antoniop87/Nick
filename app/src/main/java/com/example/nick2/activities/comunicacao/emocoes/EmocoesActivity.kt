package com.example.nick2.activities.comunicacao.emocoes

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import com.example.nick2.R
import com.example.nick2.adapter.MyGridAdapterAComunicacao
import com.example.nick2.model.ItemAudio

class EmocoesActivity : AppCompatActivity() {

    lateinit var gridView: GridView
    lateinit var btn_fechar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emocoes)
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
            ItemAudio("Papai", R.drawable.pai, R.raw.p_24973272_337),
            ItemAudio("Mamãe", R.drawable.mae, R.raw.p_40437060_672),
            ItemAudio("Vovó", R.drawable.vovoo, R.raw.p_40437081_685),
            ItemAudio("Vovô", R.drawable.vovo, R.raw.p_40437094_695),
            ItemAudio("Dormir", R.drawable.dormir, R.raw.p_40437140_736),
            ItemAudio("Te amo", R.drawable.euteamo, R.raw.p_40437112_708),
            ItemAudio("Abraço", R.drawable.abraco, R.raw.p_24973554_670),
            ItemAudio("Feliz", R.drawable.capa_sucesso, R.raw.p_40437154_750),

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