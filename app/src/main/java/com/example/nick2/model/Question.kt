package com.example.nick2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Question(
    val text: String,
    val imagemPergunta: Int,
    val correctAnswer: Int,
    val imageOptions: List<Int>
) : Parcelable

