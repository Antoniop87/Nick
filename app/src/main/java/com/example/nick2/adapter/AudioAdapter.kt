package com.example.nick2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nick2.activities.jogos.fragments.AudioFragment

data class WordItem(
    val word: String,
    val imageResId: Int // ou use String para URLs de imagem
)

class AudioAdapter(
    private val wordItems: List<WordItem>,
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = wordItems.size

    override fun createFragment(position: Int): Fragment {
        val item = wordItems[position]
        return AudioFragment.newInstance(item.word, item.imageResId)
    }
}