package com.example.nick2.activities.jogos.audio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.nick2.R
import com.example.nick2.activities.jogos.SucessoActivity
import com.example.nick2.adapter.AudioAdapter
import com.example.nick2.adapter.WordItem

class ComidaAudioActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: AudioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comida_audio)

        val btnFechar: ImageView = findViewById(R.id.btn_fechar)
        btnFechar.setOnClickListener {
            finish()
        }

        val wordItems = listOf(
            WordItem("Carne", R.drawable.carne),
            WordItem("Milho", R.drawable.milho),
            WordItem("Arroz", R.drawable.arroz),
            WordItem("Banana", R.drawable.banana_question),
            WordItem("Pão", R.drawable.pao)
        )

        viewPager = findViewById(R.id.viewPager)
        adapter = AudioAdapter(wordItems, this)
        viewPager.adapter = adapter

        viewPager.isUserInputEnabled = false // Desativa a rolagem manual

        setupFragmentListeners()
    }

    private fun setupFragmentListeners() {
        supportFragmentManager.setFragmentResultListener("wordMatched", this) { _, _ ->
            val currentPosition = viewPager.currentItem
            if (currentPosition < adapter.itemCount - 1) {
                viewPager.currentItem = currentPosition + 1
            } else {
                val i = Intent(this@ComidaAudioActivity, SucessoActivity::class.java)
                startActivity(i)
                finish()
                Toast.makeText(this, "Parabéns! Você terminou!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}