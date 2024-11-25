package com.example.nick2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nick2.activities.jogos.fragments.QuestionFragment
import com.example.nick2.model.Question

class QuestionPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val questions: List<Question>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = questions.size

    override fun createFragment(position: Int): Fragment {
        val question = questions[position]
        return QuestionFragment.newInstance(question) // Passa o objeto Question
    }
}

