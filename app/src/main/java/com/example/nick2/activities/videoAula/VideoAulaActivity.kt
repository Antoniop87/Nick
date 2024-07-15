package com.example.nick2.activities.videoAula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import com.example.nick2.R
import com.example.nick2.adapter.MyGridAdapterVideoAula
import com.example.nick2.model.Item

class VideoAulaActivity : AppCompatActivity() {

    lateinit var btn_fechar: ImageView
    lateinit var gridView: GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_aula)
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
            Item("Soma", R.drawable.soma),
            Item("Subtração", R.drawable.sub),
            Item("Divisão", R.drawable.div),
            Item("Alfabeto", R.drawable.abc),
            Item("Leitura", R.drawable.leitura),
            Item("Inglês", R.drawable.ingles),
        )

        val adapter = MyGridAdapterVideoAula(this, items)
        gridView.adapter = adapter

        gridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val item = items[position]


                val intent = when (item.name) {
                    "Soma" -> Intent(this, ExibeVideoAulaActivity::class.java).putExtra("TITULO", "Soma").putExtra("VIDEO_AULA", "<iframe width=\"100%\" height=\"100% src=\"https://www.youtube.com/embed/prsJNR0Zbqg?si=ymhZt06dMX6sBPmU\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>")
                    "Subtração" -> Intent(this, ExibeVideoAulaActivity::class.java).putExtra("TITULO", "Subtração").putExtra("VIDEO_AULA", "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/V0NVAh4Adxs?si=ueBzj11iWVWAcE7w\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>")
                    "Divisão" -> Intent(this, ExibeVideoAulaActivity::class.java).putExtra("TITULO", "Divisão").putExtra("VIDEO_AULA", "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/T7Co1o7fh6k?si=B758pbRlxTVBzJd7\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>")
                    "Alfabeto" -> Intent(this, ExibeVideoAulaActivity::class.java).putExtra("TITULO", "Alfabeto").putExtra("VIDEO_AULA", "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/JNA4-mjSf00?si=Q53qj5VtttHHA5nc\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>")
                    "Leitura" -> Intent(this, ExibeVideoAulaActivity::class.java).putExtra("TITULO", "Leitura").putExtra("VIDEO_AULA", "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/jv7-2Y5LTQw?si=oB4MSupypnxIRehh\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>")
                    else -> Intent(this, ExibeVideoAulaActivity::class.java).putExtra("TITULO", "Inglês").putExtra("VIDEO_AULA", "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/CzAobbax6KI?si=G6ar6gT0mn5fPOwV\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>")
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