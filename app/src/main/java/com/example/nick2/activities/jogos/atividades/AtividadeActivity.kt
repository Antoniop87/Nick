package com.example.nick2.activities.jogos.atividades

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.nick2.R
import com.example.nick2.adapter.QuestionPagerAdapter
import com.example.nick2.model.Question

//essa activity configura o fragment da atividade
class AtividadeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividade)

        val btnFechar: ImageView = findViewById(R.id.btn_fechar)
        btnFechar.setOnClickListener {
            finish()
        }

        val questions = listOf(
            Question(
                text = "Qual é a comida do gato?",
                imagemPergunta = R.drawable.gato,
                correctAnswer = 1,
                imageOptions = listOf(R.drawable.banana_question, R.drawable.peixe_enlatado, R.drawable.grama, R.drawable.carne)
            ),
            Question(
                text = "Qual é a comida do coelho?",
                imagemPergunta = R.drawable.coelho,
                correctAnswer = 2,
                imageOptions = listOf(R.drawable.carne, R.drawable.alga, R.drawable.cenoura, R.drawable.racao_cachorro)
            ),
            Question(
                text = "Qual é a comida da galinha?",
                imagemPergunta = R.drawable.imagem_galinha,
                correctAnswer = 3,
                imageOptions = listOf(R.drawable.grama, R.drawable.abacaxi, R.drawable.milho, R.drawable.melancia)
            ),
            Question(
                text = "Qual é a comida da vaca?",
                imagemPergunta = R.drawable.vaquinha,
                correctAnswer = 0,
                imageOptions = listOf(R.drawable.grama, R.drawable.peixe_enlatado, R.drawable.osso, R.drawable.melancia)
            ),
            Question(
                text = "Qual é a comida do cachorro?",
                imagemPergunta = R.drawable.cachorro,
                correctAnswer = 2,
                imageOptions = listOf(R.drawable.osso, R.drawable.cenoura, R.drawable.racao_cachorro, R.drawable.peixe_enlatado)
            ),
            Question(
                text = "Qual é a comida do peixe?",
                imagemPergunta = R.drawable.peixe,
                correctAnswer = 1,
                imageOptions = listOf(R.drawable.melancia, R.drawable.alga, R.drawable.abacaxi, R.drawable.banana_question)
            ),
            Question(
                text = "Qual é a comida da onça?",
                imagemPergunta = R.drawable.onca,
                correctAnswer = 3,
                imageOptions = listOf(R.drawable.milho, R.drawable.osso, R.drawable.grama, R.drawable.carne)
            )

        )

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val adapter = QuestionPagerAdapter(this, questions)
        viewPager.adapter = adapter

    }


}