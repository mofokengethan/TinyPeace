package com.example.tinypeace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tinypeace.TinyPeaceUI.homeScreen.UIPreview
import com.example.tinypeace.ui.theme.TinyPeaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIPreview()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TinyPeaceTheme {
        // UI Preview
        // UIPreview()
    }
}



