package com.example.tinypeace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tinypeace.screens.HomeScreen
import com.example.tinypeace.screens.landingScreens.CreateAccountScreen
import com.example.tinypeace.screens.landingScreens.InformationScreen
import com.example.tinypeace.screens.landingScreens.MainAppScreen
import com.example.tinypeace.ui.theme.TinyPeaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TinyPeaceTheme {
               NavHostNavigationScreen()
            }
        }
    }
}

@Composable
fun NavHostNavigationScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homeScreen") {
        composable("homeScreen") {  HomeScreen(navController) }
        composable("mainAppScreen") { MainAppScreen(navController)}
        composable("createAccountScreen") { CreateAccountScreen(navController) }
        composable("informationScreen") { InformationScreen(navController) }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TinyPeaceTheme {
        NavHostNavigationScreen()
    }
}



