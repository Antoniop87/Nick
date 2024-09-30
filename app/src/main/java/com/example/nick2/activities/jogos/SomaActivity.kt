package com.example.nick2.activities.jogos

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.nick2.R
import com.example.nick2.Util.Util

class SomaActivity : AppCompatActivity() {

    private lateinit var btn_1: Button
    private lateinit var btn_2: Button
    private lateinit var btn_3: Button
    private lateinit var btn_voltar: ImageView
    private var util: Util = Util()
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soma)
        initViews()
        configuraBtns()
    }

    override fun onResume() {
        super.onResume()
        Log.d("COUNT", "aqui ${count}")
    }

    private fun initViews(){
        btn_1 = findViewById(R.id.btn_1)
        btn_2 = findViewById(R.id.btn_2)
        btn_3 = findViewById(R.id.btn_3)
        btn_voltar = findViewById(R.id.btn_fechar)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun configuraBtns(){
        val red = ContextCompat.getColor(this, R.color.red)
        val green = ContextCompat.getColor(this, R.color.green)
        val i = Intent(this, SucessoActivity::class.java)

        btn_1.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    btn_1.setBackgroundColor(red)
                }
                MotionEvent.ACTION_UP -> {
                    Handler(Looper.getMainLooper()).postDelayed({
                        util.animateColorTransition(btn_1, red, Color.WHITE, 500)
                    }, 500)
                }
            }
            count++
            v.performClick()
            true
        }

        btn_2.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    btn_2.setBackgroundColor(green)
                }
                MotionEvent.ACTION_UP -> {

                    Handler(Looper.getMainLooper()).postDelayed({
                        util.animateColorTransition(btn_2, green, Color.WHITE, 500)
                    }, 500)
                }
            }
            count++
            startActivity(i)
            finish()
            v.performClick()
            true
        }

        btn_3.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    btn_3.setBackgroundColor(red)
                }
                MotionEvent.ACTION_UP -> {

                    Handler(Looper.getMainLooper()).postDelayed({
                        util.animateColorTransition(btn_3, red, Color.WHITE, 500)
                    }, 500)
                }
            }
            count++
            v.performClick()
            true
        }

        btn_voltar.setOnClickListener {
            finish()
        }
    }

}