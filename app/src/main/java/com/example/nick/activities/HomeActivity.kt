package com.example.nick.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nick.R
import com.example.nick.activities.ui.theme.NickTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NickTheme {
                MyGridView()
            }
        }
    }
}

@Composable
private fun GridItem(imageResId: Int, text: String, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .size(190.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clickable(onClick = onItemClick)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
private fun MyGridView() {
    val context = LocalContext.current
    val items = listOf(
        GridItemDataHome(R.drawable.abraco, "Comunicação"),
        GridItemDataHome(R.drawable.fome, "Jogos"),
    )

    val onItemClick: (String) -> Unit = { itemName ->
        Log.d("CLICOU", "Clicou no item: $itemName")
        when (itemName) {
            "Comunicação" -> {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            }
            "Jogos" -> {
                val intent = Intent(context, JogosActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items.chunked(2) { chunk ->
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    chunk.forEach { item ->
                        GridItem(imageResId = item.imageResId, text = item.text) {
                            onItemClick(item.text)
                        }
                    }
                }
            }
        }
    }
}

private data class GridItemDataHome(val imageResId: Int, val text: String)

@Preview
@Composable
private fun PreviewMyGridView() {
    MyGridView()
}
