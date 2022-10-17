package com.example.composefirst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class ImageFullView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val image = intent?.getStringExtra("imageId")
            val imageDescription = intent?.getStringExtra("contentDes")
            val imageId = image!!.toDouble()
            ImageCard(painter = painterResource(id = imageId.toInt()),
                contentDescription = imageDescription)
        }
    }

}

@Composable
fun ImageCard(painter: Painter, contentDescription: String?){
    Card( modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
        elevation = 10.dp
    ) {
        Image(painter = painter, contentDescription =contentDescription )
    }
}