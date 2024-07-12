package com.example.nick2.activities.jogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.nick2.R

class SucessoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sucesso)
        exibeActivity()
    }

    private fun exibeActivity(){
        val displayTime = 5000L

        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, displayTime)
    }

}