package com.example.nick.activities

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nick.ui.theme.NickTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.nick.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            NickTheme {
                MyGridView()
                Log.d("TESTE", "aqui")

            }

        }
    }
}
@Composable
private fun GridItem(imageResId: Int, text: String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .size(190.dp),
//        elevation = 4.dp
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
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewGridItem() {
    GridItem(
        imageResId = R.drawable.ic_launcher_background,
        text = "Nome do Item"
    )
}

@Composable
private fun MyGridView() {
    val context = LocalContext.current
    val items = listOf(
        GridItemData(R.drawable.abraco, "Abraço"),
        GridItemData(R.drawable.fome, "Fome"),
        GridItemData(R.drawable.oi, "Oi"),
//        GridItemData(R.drawable.ic_launcher_background, "Item 4"),
//        GridItemData(R.drawable.ic_launcher_background, "Item 5"),
//        GridItemData(R.drawable.ic_launcher_background, "Item 6"),
//        GridItemData(R.drawable.ic_launcher_background, "Item 7"),
//        GridItemData(R.drawable.ic_launcher_background, "Item 8"),
//        GridItemData(R.drawable.ic_launcher_background, "Item 9"),
//        GridItemData(R.drawable.ic_launcher_background, "Item 10"),
//        GridItemData(R.drawable.ic_launcher_background, "Item 11"),
//        GridItemData(R.drawable.ic_launcher_background, "Item 12")


    )

    val columnCount = 2
    val rowCount = (items.size + columnCount - 1) / columnCount

    val mediaPlayerMap = remember { mutableMapOf<String, MediaPlayer>() }


    items.forEach { item ->
        val resourceId = when (item.text) {
            "Abraço" -> R.raw.p_19393358_594
            "Fome" -> R.raw.p_19393381_629
            "Oi" -> R.raw.p_19393367_611
            
            else -> 0
        }

        val mediaPlayer = MediaPlayer.create(context, resourceId)
        mediaPlayerMap[item.text] = mediaPlayer
    }


    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items.forEachIndexed { index, item ->
            if (index % 2 == 0) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp)
                                .clickable {
                                    onItemClick(item.text)
                                    mediaPlayerMap[item.text]?.start()
                                }
                        ) {
                            GridItem(imageResId = item.imageResId, text = item.text)
                        }
                        if (index + 1 < items.size) {
                            val nextItem = items[index + 1]
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(4.dp)
                                    .clickable {
                                        onItemClick(nextItem.text)
                                        mediaPlayerMap[nextItem.text]?.start()
                                    }
                            ) {
                                GridItem(imageResId = nextItem.imageResId, text = nextItem.text)
                            }
                        }
                    }
                }
            }
        }
    }
}



private fun onItemClick(itemName: String) {
    Log.d("CLICOOU", "aqui " + itemName)
}


private data class GridItemData(val imageResId: Int, val text: String)

@Preview
@Composable
private fun PreviewMyGridView() {
    MyGridView()
}