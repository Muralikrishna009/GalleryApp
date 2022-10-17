package com.example.composefirst

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                AllRows()
                AllRows()
                AllRows()
            }
            
        }
    }

    @Composable
    private fun AllRows(){
        Row (){

            ImageCard(
                painter = R.drawable.snow_man,
                contentDescription = "Snowman playing in the snow",
                title = "Snowman playing in the snow",
                this@MainActivity
            )
            ImageCard(
                painter = R.drawable.snow_man,
                contentDescription = "Snowman playing in the snow",
                title = "Snowman playing in the snow",
                this@MainActivity
            )
        }
    }

}


@Composable
fun ImageCard(
    painter: Int, contentDescription: String, title: String,
     context: Context
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp
    ) {
        Box(
            modifier = Modifier.height(200.dp)
        ) {
            Image(
                painter = painterResource(id = painter),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable {
                        context.startActivity(Intent(context, ImageFullView::class.java)
                            .putExtra("imageId", painter.toString())
                            .putExtra("contentDes", contentDescription))
                    }
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        ),

                        )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }

}


