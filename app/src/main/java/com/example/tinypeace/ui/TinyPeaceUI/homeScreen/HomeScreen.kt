package com.example.tinypeace.TinyPeaceUI.homeScreen

import androidx.annotation.Nullable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Airlines
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBarDefaults.containerColor
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tinypeace.R
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Button
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonTextModel
import com.example.tinypeace.TinyPeaceUI.homeScreen.enums.ComponentViewTypes
import com.example.tinypeace.ui.Theme.background

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)
val googleFontDmSerifDisplay = GoogleFont("DM Serif Display")
val dmSerifDisplay = FontFamily(
    Font(
        googleFontDmSerifDisplay,
        provider
    )
)

val googleFontMontserrat = GoogleFont("Montserrat")
val montserratFamily = FontFamily(
    Font(
        googleFontMontserrat,
        provider
    )
)

@Composable
fun UIScreen(
    navController: NavController,
    appBarsScreenAction: ((com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType) -> Unit)
) {

    val scrollState = rememberScrollState()
    var selectedView by remember { mutableStateOf(ComponentViewTypes.TopBars) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier,
                containerColor = containerColor,
                contentColor = contentColorFor(containerColor),
                tonalElevation = NavigationBarDefaults.Elevation,
                windowInsets = NavigationBarDefaults.windowInsets,
            ) {
                NavigationBarItem(selected = false, onClick = {
                    /*TODO*/
                }, icon = { BadgedBox(badge = {}) {
                        Icon(imageVector = Icons.Outlined.Newspaper, contentDescription = "")
                    }
                })
                NavigationBarItem(selected = false, onClick = {
                    /*TODO*/
                }, icon = { BadgedBox(badge = {}) {
                    Icon(imageVector = Icons.Outlined.Contacts, contentDescription = "")
                }
                })
                NavigationBarItem(selected = false, onClick = {
                    /*TODO*/
                }, icon = { BadgedBox(badge = {}) {
                    Icon(imageVector = Icons.Outlined.AddCircle, contentDescription = "")
                }
                })
                NavigationBarItem(selected = false, onClick = {
                    /*TODO*/
                }, icon = { BadgedBox(badge = {}) {
                    Icon(imageVector = Icons.Outlined.Airlines, contentDescription = "")
                }
                })
                NavigationBarItem(selected = false, onClick = {
                    /*TODO*/
                }, icon = { BadgedBox(badge = {}) {
                    Icon(imageVector = Icons.Outlined.PersonOutline, contentDescription = "")
                }
                })
            }
        }
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .background(background)
                .padding(innerPadding)
                .padding(top = 48.dp)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                ViewTypeRow { viewType ->
                    selectedView = viewType
                }

                TinyPeaceComponentViews(selectedView, navController) { type ->
                    appBarsScreenAction(type)
                }
            }
        }
    }
}

@Composable
fun AppBarNavigationView(
    navController: NavController,
    buttonAction: (com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType) -> Unit
) {
    Column {
        TP_Button(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {
                    println("Top App Bar")
                    navController.navigate("appBarScreen")
                    buttonAction(TinyPeaceAppBarType.TopAppBar)
                },
                buttonType = TinyPeaceButtonType.ElevatedButton,
                modifier = Modifier
                    .padding(8.dp),
                enable = true,
                text = TinyPeaceButtonTextModel(
                    text = "Top App Bar",
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier,
                    softWrap = true,
                    maxLines = Int.MAX_VALUE,
                    minLines = 1,
                    lineHeight = TextUnit.Unspecified,
                    letterSpacing = 2.sp,
                ),
                basicIcon = null,
                iconButton = null,
                segmentedButton = null,
                onPressInteraction = null
            )
        )

        TP_Button(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {
                    println("Center Aligned Top App Bar")
                    navController.navigate("appBarScreen")
                    buttonAction(com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.CenterAlignedTopAppBar)
                },
                buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.ElevatedButton,
                modifier = Modifier
                    .padding(8.dp),
                enable = true,
                text = TinyPeaceButtonTextModel(
                    text = "Center Aligned Top App Bar",
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier,
                    softWrap = true,
                    maxLines = Int.MAX_VALUE,
                    minLines = 1,
                    lineHeight = TextUnit.Unspecified,
                    letterSpacing = 2.sp,
                ),
                basicIcon = null,
                iconButton = null,
                segmentedButton = null,
                onPressInteraction = null
            )
        )

        TP_Button(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {
                    println("Medium Top App Bar")
                    navController.navigate("appBarScreen")
                    buttonAction(com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.MediumTopAppBar)
                },
                buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.ElevatedButton,
                modifier = Modifier
                    .padding(8.dp),
                enable = true,
                text = TinyPeaceButtonTextModel(
                    text = "Medium Top App Bar",
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier,
                    softWrap = true,
                    maxLines = Int.MAX_VALUE,
                    minLines = 1,
                    lineHeight = TextUnit.Unspecified,
                    letterSpacing = 2.sp,
                ),
                basicIcon = null,
                iconButton = null,
                segmentedButton = null,
                onPressInteraction = null
            )
        )

        TP_Button(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {
                    println("Large Top App Bar")
                    navController.navigate("appBarScreen")
                    buttonAction(com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.LargeTopAppBar)
                },
                buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.ElevatedButton,
                modifier = Modifier
                    .padding(8.dp),
                enable = true,
                text = TinyPeaceButtonTextModel(
                    text = "Large Top App Bar",
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier,
                    softWrap = true,
                    maxLines = Int.MAX_VALUE,
                    minLines = 1,
                    lineHeight = TextUnit.Unspecified,
                    letterSpacing = 2.sp,
                ),
                basicIcon = null,
                iconButton = null,
                segmentedButton = null,
                onPressInteraction = null
            )
        )

        TP_Button(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {
                    println("Large Top App Bar")
                    navController.navigate("appBarScreen")
                    buttonAction(com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.BottomAppBar)
                },
                buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.ElevatedButton,
                modifier = Modifier
                    .padding(8.dp),
                enable = true,
                text = TinyPeaceButtonTextModel(
                    text = "Bottom App Bar",
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier,
                    softWrap = true,
                    maxLines = Int.MAX_VALUE,
                    minLines = 1,
                    lineHeight = TextUnit.Unspecified,
                    letterSpacing = 2.sp,
                ),
                basicIcon = null,
                iconButton = null,
                segmentedButton = null,
                onPressInteraction = null
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    UIScreen(rememberNavController()) {

    }
}
