package com.example.nick2.activities.jogos.atividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.nick2.R
import com.example.nick2.adapter.QuestionPagerAdapter
import com.example.nick2.model.Question

class CoresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cores)

        val btnFechar: ImageView = findViewById(R.id.btn_fechar)
        btnFechar.setOnClickListener {
            finish()
        }

        val questions = listOf(
            Question(
                text = "Qual imagem mostra algo vermelho?",
                imagemPergunta = R.drawable.paleta,
                correctAnswer = 0,
                imageOptions = listOf(
                    R.drawable.maca,
                    R.drawable.kiwi,
                    R.drawable.laranja,
                    R.drawable.gato
                )
            ), Question(
                text = "Qual dessas imagens mostra algo azul?",
                imagemPergunta = R.drawable.paleta,
                correctAnswer = 2,
                imageOptions = listOf(
                    R.drawable.ilha,
                    R.drawable.carro,
                    R.drawable.ceu,
                    R.drawable.leao
                )
            ), Question(
                text = "Qual dessas frutas é amarela?",
                imagemPergunta = R.drawable.paleta,
                correctAnswer = 1,
                imageOptions = listOf(
                    R.drawable.laranja,
                    R.drawable.banana_question,
                    R.drawable.maca,
                    R.drawable.camaleao
                )
            ),Question(
                text = "Qual dessas imagens mostra a cor verde?",
                imagemPergunta = R.drawable.paleta,
                correctAnswer = 3,
                imageOptions = listOf(
                    R.drawable.carro,
                    R.drawable.banana_question,
                    R.drawable.maca,
                    R.drawable.camaleao
                )
            ),

        )

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val adapter = QuestionPagerAdapter(this, questions)
        viewPager.adapter = adapter
    }
}