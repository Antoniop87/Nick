package com.example.nick2.activities.jogos

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.nick2.R
import com.example.nick2.adapter.QuestionPagerAdapter
import com.example.nick2.model.Question

class AtividadeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividade)

        val questions = listOf(
            Question(
                text = "Qual é o animal?",
                correctAnswer = 1,
                imageOptions = listOf(R.drawable.banana, R.drawable.macaco, R.drawable.mae, R.drawable.abraco)
            ),
            Question(
                text = "Qual é a fruta?",
                correctAnswer = 2,
                imageOptions = listOf(R.drawable.capa_falas, R.drawable.hi, R.drawable.banana, R.drawable.capa_macaco)
            )
        )

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val adapter = QuestionPagerAdapter(this, questions) // Aqui você passa 'this'
        viewPager.adapter = adapter

    }


}