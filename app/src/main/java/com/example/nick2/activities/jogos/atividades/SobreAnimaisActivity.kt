package com.example.nick2.activities.jogos.atividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.nick2.R
import com.example.nick2.adapter.QuestionPagerAdapter
import com.example.nick2.model.Question

class SobreAnimaisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre_animais)

        val btnFechar: ImageView = findViewById(R.id.btn_fechar)
        btnFechar.setOnClickListener {
            finish()
        }

        val questions = listOf(
            Question(
                text = "Qual animal é conhecido como o Rei da Selva?",
                imagemPergunta = R.drawable.rei,
                correctAnswer = 2,
                imageOptions = listOf(
                    R.drawable.onca,
                    R.drawable.cachorro,
                    R.drawable.leao,
                    R.drawable.gato
                )
            ), Question(
                text = "Qual desses animais vive na água?",
                imagemPergunta = R.drawable.oceano,
                correctAnswer = 1,
                imageOptions = listOf(
                    R.drawable.leao,
                    R.drawable.peixe,
                    R.drawable.imagem_galinha,
                    R.drawable.coelho
                )
            ), Question(
                text = "Qual desses animais tem asas e pode voar?",
                imagemPergunta = R.drawable.ceu,
                correctAnswer = 3,
                imageOptions = listOf(
                    R.drawable.tubarao,
                    R.drawable.urso,
                    R.drawable.cachorro,
                    R.drawable.passaro
                )
            ), Question(
                text = "Qual desses animais é o maior predador dos oceanos?",
                imagemPergunta = R.drawable.oceano,
                correctAnswer = 2,
                imageOptions = listOf(
                    R.drawable.onca,
                    R.drawable.golfinho,
                    R.drawable.tubarao,
                    R.drawable.baleia
                )
            ), Question(
                text = "Qual desses animais gosta de mel?",
                imagemPergunta = R.drawable.mel,
                correctAnswer = 0,
                imageOptions = listOf(
                    R.drawable.urso,
                    R.drawable.leao,
                    R.drawable.cachorro,
                    R.drawable.imagem_galinha
                )
            )

        )

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val adapter = QuestionPagerAdapter(this, questions)
        viewPager.adapter = adapter

    }
}