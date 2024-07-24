package com.example.tinypeace.model.enums.demographicScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tinypeace.screens.GridSquare
import com.example.tinypeace.model.enums.Nationality
import com.example.tinypeace.ui.theme.TinyPeaceTheme

@Composable
fun NationalityScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
    ) {
        LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 180.dp)) {
            for (major in Nationality.entries) {
                item {
                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        GridSquare(
                            title = major.emoji + " " + major.description
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NationalityPreview() {
    TinyPeaceTheme {
        NationalityScreen()
    }
}