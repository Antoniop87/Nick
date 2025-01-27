package com.example.nick2.activities.jogos

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import com.example.nick2.R

class AcerteAFrutaActivity : AppCompatActivity() {

    private lateinit var draggableTextView: TextView


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acerte_afruta)

        draggableTextView = findViewById(R.id.draggableTextView)

        draggableTextView.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val shadowBuilder = View.DragShadowBuilder(view)
                view.startDragAndDrop(null, shadowBuilder, view, 0)
                view.visibility = View.INVISIBLE
                true
            } else {
                false
            }
        }

        draggableTextView.setOnDragListener { view, dragEvent ->
            when (dragEvent.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    true
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    true
                }
                DragEvent.ACTION_DRAG_LOCATION -> {
                    true
                }
                DragEvent.ACTION_DRAG_EXITED -> {
                    true
                }
                DragEvent.ACTION_DROP -> {
                    // Get the dragged view and reposition it
                    val draggedView = dragEvent.localState as View
                    draggedView.x = dragEvent.x - draggedView.width / 2
                    draggedView.y = dragEvent.y - draggedView.height / 2
                    draggedView.visibility = View.VISIBLE
                    true
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    // Make sure the view is visible after the drag ends
                    view.visibility = View.VISIBLE
                    true
                }
                else -> {
                    false
                }
            }
        }

    }

}