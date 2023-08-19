package com.example.jetpackcomposeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextModelCompose(
    text: String,
    modifier: Modifier = Modifier,
    size: TextUnit = 15.sp,
    padding: Dp = 0.dp
) {
    Text(
        text = text,
        fontSize = size,
        modifier = modifier
            .wrapContentSize()
            .padding(padding),
        color = Color.Black
    )
}

@Composable
fun ImageModelCompose(
    painter: Painter,
    contentDirection: String = "",
    modifier: Modifier = Modifier,
    alpha: Float = 1f,
    fillMaxSize: Float = 0.4f
) {
    Image(
        painter = painter,
        contentDescription = contentDirection,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(CircleShape)
            .fillMaxSize(fillMaxSize),
        alpha = alpha
    )
}

@Composable
fun ItemCompose(
    painter: Painter,
    contentDirection: String = "",
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(20.dp)
            .size(80.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(red = 0.824f, green = 0.706f, blue = 0.649f))
            .border(1.dp, Color(red = 0.624f, green = 0.506f, blue = 0.449f)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ImageModelCompose(painter = painter, contentDirection = contentDirection)
            TextModelCompose(text = text, size = 10.sp)
        }
    }
}

@Preview
@Composable
fun BackgroundCompose(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(red = 0.824f, green = 0.706f, blue = 0.649f)),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextModelCompose(text = "Choose a device", size = 30.sp, padding = 20.dp)

            Box(
                modifier = Modifier.wrapContentSize(),
                contentAlignment = Alignment.Center
            ) {
                ImageModelCompose(
                    painter = painterResource(id = R.drawable.backraund),
                    alpha = 0.6f,
                    fillMaxSize = 0.8f
                )
                Row {
                    Column {
                        ItemCompose(
                            painter = painterResource(id = R.drawable.printer),
                            text = "Printer"
                        )
                        ItemCompose(
                            painter = painterResource(id = R.drawable.monitor),
                            text = "Monitor"
                        )
                        ItemCompose(
                            painter = painterResource(
                                id = R.drawable.headphones
                            ),
                            text = "Headphones"
                        )
                    }

                    Column {
                        ItemCompose(
                            painter = painterResource(id = R.drawable.camera),
                            text = "Camera"
                        )
                        ItemCompose(
                            painter = painterResource(id = R.drawable.microphone),
                            text = "Microphone"
                        )
                        ItemCompose(
                            painter = painterResource(id = R.drawable.keyboard),
                            text = "Keyboard"
                        )
                    }
                }
            }
        }
    }
}

