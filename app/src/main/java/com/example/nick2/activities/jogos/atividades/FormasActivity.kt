package com.example.nick2.activities.jogos.atividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.nick2.R
import com.example.nick2.adapter.QuestionPagerAdapter
import com.example.nick2.model.Question

class FormasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formas)

        val btnFechar: ImageView = findViewById(R.id.btn_fechar)
        btnFechar.setOnClickListener {
            finish()
        }

        val questions = listOf(
            Question(
                text = "Qual dessas imagens mostra um círculo?",
                imagemPergunta = R.drawable.formas,
                correctAnswer = 3,
                imageOptions = listOf(
                    R.drawable.retangulo,
                    R.drawable.cachorro,
                    R.drawable.leao,
                    R.drawable.bola
                )
            ),Question(
                text = "Qual dessas imagens é um triângulo?",
                imagemPergunta = R.drawable.formas,
                correctAnswer = 1,
                imageOptions = listOf(
                    R.drawable.bola,
                    R.drawable.triangulo,
                    R.drawable.laranja,
                    R.drawable.quadrado
                )
            ),Question(
                text = "Qual dessas imagens é um quadrado?",
                imagemPergunta = R.drawable.formas,
                correctAnswer = 0,
                imageOptions = listOf(
                    R.drawable.quadrado,
                    R.drawable.triangulo,
                    R.drawable.maca,
                    R.drawable.bola
                )
            ),Question(
                text = "Qual dessas imagens é um retângulo?",
                imagemPergunta = R.drawable.formas,
                correctAnswer = 2,
                imageOptions = listOf(
                    R.drawable.triangulo,
                    R.drawable.bola,
                    R.drawable.retangulo,
                    R.drawable.gato
                )
            ),

        )

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val adapter = QuestionPagerAdapter(this, questions)
        viewPager.adapter = adapter

    }
}