package com.example.nick2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nick2.R
import com.example.nick2.activities.jogos.fragments.QuestionFragment

//class QuestionAdapter(fragmentActivity: FragmentActivity, private val questions: List<Triple<String, List<String>, String>>) : FragmentStateAdapter(fragmentActivity) {
//
//    override fun getItemCount(): Int = questions.size
//
//    override fun createFragment(position: Int): Fragment {
//        val question = questions[position].first
//        val answers = ArrayList(questions[position].second)
//        val correctAnswer = questions[position].third
//
//        // Exemplo de recursos de imagem (IDs dos recursos das imagens das alternativas)
//        val imageResIds = arrayListOf(
//            R.drawable.abc,
//            R.drawable.abraco,
//            R.drawable.eu_quero,
//            R.drawable.numero_tres,
//        )
//
//        return QuestionFragment.newInstance(question, answers, correctAnswer, imageResIds)
//    }
//}
