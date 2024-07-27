package com.example.tinypeace.TinyPeaceUI.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tinypeace.TinyPeaceUI.homeScreen.viewModel.AppBarViewModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceViews.TP_AppBarView

@Composable
fun UIPreview() {
    val navController = rememberNavController()
    val appBarVM = AppBarViewModel()

    appBarVM.setAppBarType(com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.TopAppBar)

    NavHost(navController = navController, startDestination = "homeScreen") {
        composable("homeScreen") {
            appBarVM.appBarType.value?.let {
                UIScreen(navController) { topAppBarType ->
                    appBarVM.setAppBarType(topAppBarType)
                }
            }
        }
        composable("appBarScreen") {
            appBarVM.appBarType.value?.let {
                TP_AppBarView(appBarViewModel = it) { padding ->
                    Column(modifier = Modifier.padding(padding)) {
                        Button(
                            modifier = Modifier.padding(20.dp),
                            onClick = {
                                navController.navigate("homeScreen")
                            }) {
                            Text("Back")
                        }
                    }
                }
            }
        }
    }
}