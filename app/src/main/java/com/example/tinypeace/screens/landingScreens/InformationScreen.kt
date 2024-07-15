package com.example.tinypeace.screens.landingScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tinypeace.ui.theme.TinyPeaceTheme

@Composable
fun InformationScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
    ) {

        Button(
            onClick = {
                navController.navigate("homeScreen")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Home Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InformationPreview() {
    TinyPeaceTheme {
        InformationScreen(navController = rememberNavController())
    }
}

