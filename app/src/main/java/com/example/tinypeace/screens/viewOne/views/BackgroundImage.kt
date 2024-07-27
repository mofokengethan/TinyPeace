package com.example.tinypeace.screens.viewOne.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BackgroundImage(drawableId: Int) {
    Image(
        painter = painterResource(id = drawableId),
        contentDescription = "drawableId: $drawableId",
        contentScale = ContentScale.FillBounds,
        alpha = 0.18f,
        modifier = Modifier
            .padding(8.dp)
            .border(BorderStroke(1.6.dp, Color.Black))
            .fillMaxWidth(1f)
            .height(400.dp)
            .background(color = Color.Black)
    )
}