package com.example.nick2.activities.jogos

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.nick2.R
import com.example.nick2.adapter.AudioAdapter
import com.example.nick2.adapter.WordItem

class NomeFrutaActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: AudioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nome_fruta)

        val wordItems = listOf(
            WordItem("Gato", R.drawable.onca),
            WordItem("Cachorro", R.drawable.peixe),
            WordItem("Pássaro", R.drawable.cachorro)
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
                Toast.makeText(this, "Parabéns! Você terminou!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}