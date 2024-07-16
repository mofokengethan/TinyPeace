package com.example.tinypeace.screens.landingScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tinypeace.ui.theme.TinyPeaceTheme
import java.util.logging.Filter

enum class MainScreenType {
    // Screens
    HOME,
    FRIENDS,
    SEARCH,
    PROFILE,
    // Header
    SETTINGS,
    FRIEND_SETTINGS,
    FILTERS

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScreen(navController: NavController) {

    var mainScreenType by remember {
        mutableStateOf(MainScreenType.HOME)
    }

    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(12.dp)
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("TinyPeace") },
                    actions = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("(1)", modifier = Modifier.padding(vertical = 0.dp))
                            Image(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Edit",
                                modifier = Modifier
                                    .padding(end = 8.dp)
                            )
                        }
                        Image(
                            imageVector = Icons.Default.Face,
                            contentDescription = "Add",
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                        )
                        Image(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Edit",
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                        )
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    actions = {
                        IconButton(onClick = {
                            mainScreenType = MainScreenType.HOME
                        }) {
                            Icon(
                                Icons.Filled.MailOutline,
                                contentDescription = "Localized description"
                            )
                        }
                        IconButton(onClick = {
                            mainScreenType = MainScreenType.FRIENDS
                        }) {
                            Icon(
                                Icons.Filled.FavoriteBorder,
                                contentDescription = "Localized description",
                            )
                        }

                        IconButton(onClick = {
                            mainScreenType = MainScreenType.SEARCH
                        }) {
                            Icon(
                                Icons.Filled.Search,
                                contentDescription = "Localized description",
                            )
                        }
                        IconButton(onClick = {
                            mainScreenType = MainScreenType.PROFILE
                        }) {
                            Icon(
                                Icons.Filled.Person,
                                contentDescription = "Localized description",
                            )
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                /* do something */
                            },
                            containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                        ) {
                            Icon(Icons.Filled.Add, "Localized description")
                        }
                    }
                )
            },
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                when (mainScreenType) {
                    MainScreenType.HOME -> MainHomeScreen(navController)
                    MainScreenType.FRIENDS -> FriendsHomeScreen(navController)
                    MainScreenType.SEARCH -> SearchHomeScreen(navController)
                    MainScreenType.PROFILE -> ProfileHomeScreen(navController)
                    MainScreenType.SETTINGS -> SettingsHeaderScreen(navController)
                    MainScreenType.FRIEND_SETTINGS -> FriendsHeaderScreen(navController)
                    MainScreenType.FILTERS -> FilterHeaderScreen(navController)
                }
            }
        }
    }
}

@Composable
fun PostCard(
    postText: String,
    author: String,
    city: String,
    state: String,
    category: String,
    onLikeClicked: () -> Unit,
    onDislikeClicked: () -> Unit,
    onDownArrowClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .border(BorderStroke(1.dp, Color.Black))
            .padding(6.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.Top,
        ) {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
               Column(
                   modifier = Modifier.weight(1f)
               ) {
                   Text(
                       text = category,
                       style = MaterialTheme.typography.bodySmall,
                   )

                   Text(
                       text = "$city, $state",
                       style = MaterialTheme.typography.bodyMedium
                   )
               }
                IconButton(onClick = onDownArrowClicked) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "More options")
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = postText,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Author: $author",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .weight(1f)
                )

                IconButton(onClick = onDislikeClicked) {
                    Icon(Icons.Default.ThumbUp, contentDescription = "Vote")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Composable
fun MainHomeScreen(navController: NavController) {
    Column {
        Button(
            onClick = {
                navController.navigate("homeScreen")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Home Screen Screen")
        }
    }
}

@Composable
fun FriendsHomeScreen(navController: NavController) {
    Column {
        Button(
            onClick = {
                navController.navigate("homeScreen")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Friends Screen")
        }
    }
}
@Composable
fun SearchHomeScreen(navController: NavController) {
    Column {
        Button(
            onClick = {
                navController.navigate("homeScreen")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search Screen")
        }
    }
}
@Composable
fun ProfileHomeScreen(navController: NavController) {
    Column {
        Button(
            onClick = {
                navController.navigate("homeScreen")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Profile Screen")
        }
    }
}
@Composable
fun FilterHeaderScreen(navController: NavController) {
    Column {
        Button(
            onClick = {
                navController.navigate("homeScreen")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Friends Screen")
        }
    }
}
@Composable
fun SettingsHeaderScreen(navController: NavController) {
    Column {
        Button(
            onClick = {
                navController.navigate("homeScreen")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Friends Screen")
        }
    }
}
@Composable
fun FriendsHeaderScreen(navController: NavController) {
    Column {
        Button(
            onClick = {
                navController.navigate("homeScreen")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Friends Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainAppPreview() {
    TinyPeaceTheme {
        MainAppScreen(navController = rememberNavController())
    }
}