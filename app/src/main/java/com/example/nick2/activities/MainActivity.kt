package com.example.nick2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.example.nick2.R
import com.example.nick2.adapter.MyGridAdapter
import com.example.nick2.model.Item

class MainActivity : AppCompatActivity() {

    lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        configuraGridView()

    }

    fun initViews(){
       gridView = findViewById(R.id.gridView)
    }

    fun configuraGridView(){
        val items = listOf(
            Item("Item 1", R.drawable.ic_launcher_background),
            Item("Item 2", R.drawable.ic_launcher_background),
            Item("Item 3", R.drawable.ic_launcher_background),
            )

        val adapter = MyGridAdapter(this, items)
        gridView.adapter = adapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val item = items[position]


            val intent = when (item.name) {
                "Item 1" -> Intent(this, JogosActivity::class.java)
                "Item 2" -> Intent(this, JogosActivity::class.java)
                else -> Intent(this, JogosActivity::class.java) // Atividade padrão se necessário
            }

            startActivity(intent)
        }
    }

}