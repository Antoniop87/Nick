package com.example.nick2.activities.jogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.nick2.R

class NomeFrutaActivity : AppCompatActivity() {

    private lateinit var btn_fechar: ImageView
    private lateinit var iv_uva:ImageView
    private lateinit var iv_morango:ImageView
    private lateinit var iv_banana:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nome_fruta)
        initViews()
        configuraButtons()

    }

    private fun initViews(){
        btn_fechar = findViewById(R.id.btn_fechar)
        iv_uva = findViewById(R.id.iv_uva)
        iv_morango = findViewById(R.id.iv_morango)
        iv_banana = findViewById(R.id.iv_banana)
    }

    private fun configuraButtons(){

        iv_uva.setOnClickListener {
            Toast.makeText(this@NomeFrutaActivity, "Uva", Toast.LENGTH_LONG).show()
        }

        iv_morango.setOnClickListener {
            Toast.makeText(this@NomeFrutaActivity, "morango", Toast.LENGTH_LONG).show()
        }

        iv_banana.setOnClickListener {
            Toast.makeText(this@NomeFrutaActivity, "banana", Toast.LENGTH_LONG).show()
        }

        btn_fechar.setOnClickListener {
            finish()
        }

    }

}