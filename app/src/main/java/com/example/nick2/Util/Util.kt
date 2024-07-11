package com.example.nick2.Util

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.widget.Button

class Util {
    fun animateColorTransition(button: Button, startColor: Int, endColor: Int, duration: Long) {
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), startColor, endColor)
        colorAnimation.duration = duration
        colorAnimation.addUpdateListener { animator ->
            button.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()
    }
}