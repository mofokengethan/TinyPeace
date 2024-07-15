package com.example.tinypeace.screens.landingScreens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tinypeace.ui.theme.TinyPeaceTheme

@Composable
fun CreateAccountScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordMatch by remember { mutableStateOf("") }
    val gridList = mutableListOf(
        "Zodiac Sign",
        "Chinese Zodiac",
        "Education Level",
        "Marital Status",
        "Income Level",
        "House Hold Type",
        "Nationality",
        "Spoken Languages",
        "College Majors",
        "Top Interest"
    )


    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(12.dp)
    ) {

        Column {

            Text(
                text = "Create Account Screen"
            )

            OutlinedTextField(
                value = email,
                onValueChange = { value ->
                    email = value
                },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )


            OutlinedTextField(
                value = password,
                onValueChange = { value ->
                    password = value
                },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = passwordMatch,
                onValueChange = { value ->
                    passwordMatch = value
                },
                label = { Text("Match Password") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    navController.navigate("homeScreen")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text("Back")
            }

            Button(
                onClick = {
                    navController.navigate("mainAppScreen")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text("Create Account")
            }

            Column {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    items(gridList.size) { index ->
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .aspectRatio(1f)
                                .border(1.dp, MaterialTheme.colorScheme.primary)
                        ) {
                            Text(
                                text = gridList[index],
                                modifier = Modifier
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CreateAccountPreview() {
    TinyPeaceTheme {
        CreateAccountScreen(navController = rememberNavController())
    }
}
