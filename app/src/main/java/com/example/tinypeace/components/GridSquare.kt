package com.example.tinypeace.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tinypeace.ui.theme.TinyPeaceTheme

@Composable
fun GridSquare(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .padding(12.dp)
            .shadow(1.dp)
            .padding(24.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    TinyPeaceTheme {
        GridSquare("Dragon 🐉")
    }
}