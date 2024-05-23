package com.example.nick.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.nick.activities.ui.theme.NickTheme
import kotlin.math.roundToInt

class JogosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NickTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    DragAndDropExample()
                }
            }
        }
    }
}

@Composable
fun DragAndDropExample() {
    val context = LocalContext.current
    var dragOffset1 by remember { mutableStateOf(Offset.Zero) }
    var dragOffset2 by remember { mutableStateOf(Offset.Zero) }
    var dragOffset3 by remember { mutableStateOf(Offset.Zero) }
    var isDragging by remember { mutableStateOf(false) }
    var isDroppedInBox by remember { mutableStateOf(false) }
    var correctItemDropped by remember { mutableStateOf(false) }
    val correctItemId = 2

    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Drop target box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Gray, RoundedCornerShape(8.dp))
                .align(Alignment.BottomCenter)
        ) {
            // Draggable item inside the target box when dropped
            if (isDroppedInBox && correctItemDropped) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.Center)
                        .background(Color.Blue, RoundedCornerShape(8.dp))
                ) {
                    Text(
                        text = "Item inside the box",
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }

        // Row for draggable items
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Draggable item 1
            if (!(isDroppedInBox && correctItemDropped && correctItemId == 1)) {
                DraggableItem(
                    id = 1,
                    dragOffset = dragOffset1,
                    onDrag = { offset -> dragOffset1 = offset },
                    onDrop = { itemId ->
                        handleDrop(
                            context,
                            itemId,
                            correctItemId,
                            dragOffset1,
                            setDragOffset = { dragOffset1 = it },
                            setIsDroppedInBox = { isDroppedInBox = it },
                            setCorrectItemDropped = { correctItemDropped = it }
                        )
                    }
                )
            }

            // Draggable item 2
            if (!(isDroppedInBox && correctItemDropped && correctItemId == 2)) {
                DraggableItem(
                    id = 2,
                    dragOffset = dragOffset2,
                    onDrag = { offset -> dragOffset2 = offset },
                    onDrop = { itemId ->
                        handleDrop(
                            context,
                            itemId,
                            correctItemId,
                            dragOffset2,
                            setDragOffset = { dragOffset2 = it },
                            setIsDroppedInBox = { isDroppedInBox = it },
                            setCorrectItemDropped = { correctItemDropped = it }
                        )
                    }
                )
            }

            // Draggable item 3
            if (!(isDroppedInBox && correctItemDropped && correctItemId == 3)) {
                DraggableItem(
                    id = 3,
                    dragOffset = dragOffset3,
                    onDrag = { offset -> dragOffset3 = offset },
                    onDrop = { itemId ->
                        handleDrop(
                            context,
                            itemId,
                            correctItemId,
                            dragOffset3,
                            setDragOffset = { dragOffset3 = it },
                            setIsDroppedInBox = { isDroppedInBox = it },
                            setCorrectItemDropped = { correctItemDropped = it }
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun DraggableItem(
    id: Int,
    dragOffset: Offset,
    onDrag: (Offset) -> Unit,
    onDrop: (Int) -> Unit
) {
    var localDragOffset by remember { mutableStateOf(dragOffset) }
    var isDragging by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .size(100.dp)
            .zIndex(if (isDragging) 1f else 0f)
            .offset { IntOffset(localDragOffset.x.roundToInt(), localDragOffset.y.roundToInt()) }
            .background(Color.Blue, RoundedCornerShape(8.dp))
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = {
                        isDragging = true
                    },
                    onDragEnd = {
                        isDragging = false
                        onDrop(id)
                        localDragOffset = Offset.Zero // Reset position
                        onDrag(localDragOffset)
                    },
                    onDragCancel = {
                        isDragging = false
                        localDragOffset = Offset.Zero // Reset position
                        onDrag(localDragOffset)
                    },
                    onDrag = { change, dragAmount ->
                        change.consume()
                        localDragOffset += dragAmount
                        onDrag(localDragOffset)
                    }
                )
            }
    ) {
        Text(
            text = "Item $id",
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

fun handleDrop(
    context: android.content.Context,
    itemId: Int,
    correctItemId: Int,
    dragOffset: Offset,
    setDragOffset: (Offset) -> Unit,
    setIsDroppedInBox: (Boolean) -> Unit,
    setCorrectItemDropped: (Boolean) -> Unit
) {
    if (dragOffset.y > 1600) { // Ajuste conforme necessário
        if (itemId == correctItemId) {
            setIsDroppedInBox(true)
            setCorrectItemDropped(true)
            Toast.makeText(context, "Sucesso!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Item incorreto", Toast.LENGTH_SHORT).show()
        }
    }
    setDragOffset(Offset.Zero) // Restaura a posição inicial do item
}
