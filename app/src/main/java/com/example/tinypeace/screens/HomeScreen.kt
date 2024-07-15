package com.example.tinypeace.screens


import androidx.annotation.Nullable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.tinypeace.components.Material3ButtonType
import com.example.tinypeace.components.Material3SegmentedButtonType
import com.example.tinypeace.components.TinyPeaceBasicIconModel
import com.example.tinypeace.components.TinyPeaceButtonInteraction
import com.example.tinypeace.components.TinyPeaceButtonModel
import com.example.tinypeace.components.TinyPeaceButtonStyleType
import com.example.tinypeace.components.TinyPeaceButtonTextModel
import com.example.tinypeace.components.TinyPeaceButtons
import com.example.tinypeace.components.TinyPeaceIconButtonModel
import com.example.tinypeace.components.TinyPeaceSegmentedButtonModel
import com.example.tinypeace.ui.theme.TinyPeaceTheme
import com.example.tinypeace.ui.theme.background
import com.example.tinypeace.ui.theme.color1
import com.example.tinypeace.ui.theme.color2
import com.example.tinypeace.ui.theme.color3
import com.example.tinypeace.ui.theme.color4

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
fun HomeScreen(navController: NavController) {

    val scrollState = rememberScrollState()
    var email by remember { mutableStateOf("Email") }
    var password by remember { mutableStateOf("Password") }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(background)
            .padding(top = 48.dp)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "TinyPeace",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(24.dp)
            )

            IconButtonView()

            ButtonView()

            Button2View()

            Button3View()

            SegmentedButtonsView()

            BasicTextField(
                value = email,
                textStyle = MaterialTheme.typography.bodyMedium,
                onValueChange = { value ->
                    email = value
                },
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .background(color1)
                    .padding(24.dp)
            )

            BasicTextField(
                value = password,
                textStyle = MaterialTheme.typography.bodyMedium,
                onValueChange = { value ->
                    password = value
                },
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .background(color2)
                    .padding(24.dp)
            )

            Text(
                text = "Create Account",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .background(color3)
                    .padding(16.dp)
                    .clickable {
                        navController.navigate("createAccountScreen")
                    }
            )

            Text(
                text = "Login",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .background(color4)
                    .padding(16.dp)
                    .clickable {
                        navController.navigate("homeScreen")
                    }
            )

            Spacer(modifier = Modifier.height(16.dp))

           Column(
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier.fillMaxWidth(1f)
           ) {
                Icon(
                    Icons.Outlined.Info,
                    "Info.Circle",
                    Modifier
                        .background(Color.Transparent)
                        .clickable {
                            navController.navigate("informationScreen")
                        }
                        .padding(24.dp)
                )
           }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TinyPeaceTheme {
        HomeScreen(navController = rememberNavController())
    }
}

@Composable
fun ButtonView() {
    Row {
        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {},
                buttonType = Material3ButtonType.ExtendedFloatingActionButton,
                modifier = Modifier
                    .padding(12.dp),
                enable = true,
                text = null,
                basicIcon = TinyPeaceBasicIconModel(
                    imageVector = Icons.Default.Build,
                    description = "String",
                    modifier = Modifier
                        .padding(8.dp)
                ),
                iconButton = null,
                segmentedButton = null,
                onPressInteraction = null
            )
        )

        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {

                },
                buttonType = Material3ButtonType.FloatingActionButton,
                modifier = Modifier
                    .padding(8.dp),
                enable = true,
                text = null,
                basicIcon = TinyPeaceBasicIconModel(
                    imageVector = Icons.Default.Build,
                    description = "String",
                    modifier = Modifier
                        .padding(8.dp)
                ),
                iconButton = null,
                segmentedButton = null,
                onPressInteraction = null
            )
        )
    }
}

@Composable
fun Button2View() {
    TinyPeaceButtons(
        tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
            action = {

            },
            buttonType = Material3ButtonType.FilledButton,
            modifier = Modifier
                .padding(8.dp),
            enable = true,
            text = TinyPeaceButtonTextModel(
                text = "Filled Button",
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

    TinyPeaceButtons(
        tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
            action = {

            },
            buttonType = Material3ButtonType.FilledTonalButton,
            modifier = Modifier
                .padding(8.dp),
            enable = true,
            text = TinyPeaceButtonTextModel(
                text = "Filled Tonal Button",
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

    TinyPeaceButtons(
        tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
            action = {

            },
            buttonType = Material3ButtonType.ElevatedButton,
            modifier = Modifier
                .padding(8.dp),
            enable = true,
            text = TinyPeaceButtonTextModel(
                text = "Elevated Button",
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

    TinyPeaceButtons(
        tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
            action = {

            },
            buttonType = Material3ButtonType.OutlinedButton,
            modifier = Modifier
                .padding(8.dp),
            enable = true,
            basicIcon = null,
            iconButton = null,
            text = TinyPeaceButtonTextModel(
                text = "Outlined Button",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier,
                softWrap = true,
                maxLines = Int.MAX_VALUE,
                minLines = 1,
                lineHeight = TextUnit.Unspecified,
                letterSpacing = 2.sp,
            ),
            segmentedButton = null,
            onPressInteraction = null
        )
    )
}

@Composable
fun Button3View() {
    Row {
        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {

                },
                buttonType = Material3ButtonType.TextButton,
                modifier = Modifier
                    .padding(8.dp),
                enable = true,
                text = TinyPeaceButtonTextModel(
                    text = "Text Button",
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

@Composable
fun SegmentedButtonsView (
) {
    val checkedList = remember { mutableStateListOf<Int>() }
    Column {
        TinyPeaceButtons(tinyPeaceButtonModel = TinyPeaceButtonModel<String> (
            action = {},
            buttonType = Material3ButtonType.SegmentedButton,
            modifier = Modifier
                .padding(8.dp),
            enable = true,
            text = null,
            basicIcon = null,
            iconButton = null,
            segmentedButton = TinyPeaceSegmentedButtonModel(
                segmentedButtonType = Material3SegmentedButtonType.SingleChoiceSegmentedButton,
                checkedList = checkedList,
                options = listOf("Favorites", "Trending", "Saved"),
                icons =  listOf(
                    Icons.Filled.StarBorder,
                    Icons.AutoMirrored.Filled.TrendingUp,
                    Icons.Filled.BookmarkBorder
                )
            ),
            onPressInteraction = null
        ))

        TinyPeaceButtons(tinyPeaceButtonModel = TinyPeaceButtonModel<String> (
            action = {},
            buttonType = Material3ButtonType.SegmentedButton,
            modifier = Modifier
                .padding(8.dp),
            enable = true,
            text = null,
            basicIcon = null,
            iconButton = null,
            segmentedButton = TinyPeaceSegmentedButtonModel(
                segmentedButtonType = Material3SegmentedButtonType.MultiChoiceSegmentedButton,
                checkedList = checkedList,
                options = listOf("Favorites", "Trending", "Saved"),
                icons =  listOf(
                    Icons.Filled.StarBorder,
                    Icons.AutoMirrored.Filled.TrendingUp,
                    Icons.Filled.BookmarkBorder
                )
            ),
            onPressInteraction = null
        ))
    }
}

@Composable
fun IconButtonView() {
    Row {
        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {},
                buttonType = Material3ButtonType.IconButton,
                modifier = Modifier
                    .padding(8.dp),
                enable = true,
                text = null,
                basicIcon = TinyPeaceBasicIconModel(
                    imageVector = Icons.Default.Build,
                    description = "String",
                    modifier = Modifier
                        .padding(8.dp)
                ),
                iconButton = TinyPeaceIconButtonModel(
                    iconButtonColorType = TinyPeaceButtonStyleType.Filled,
                    iconButtonModifier = Modifier
                        .padding(8.dp)
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {

                },
                buttonType = Material3ButtonType.IconButton,
                modifier = Modifier
                    .padding(8.dp),
                enable = true,
                text = null,
                basicIcon = TinyPeaceBasicIconModel(
                    imageVector = Icons.Default.Build,
                    description = "String",
                    modifier = Modifier
                        .padding(8.dp)
                ),
                iconButton = TinyPeaceIconButtonModel(
                    iconButtonColorType = TinyPeaceButtonStyleType.Regular,
                    iconButtonModifier = Modifier
                        .padding(8.dp)
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {

                },
                buttonType = Material3ButtonType.IconButton,
                modifier = Modifier
                    .padding(8.dp),
                enable = true,
                text = null,
                basicIcon = TinyPeaceBasicIconModel(
                    imageVector = Icons.Default.Build,
                    description = "String",
                    modifier = Modifier
                        .padding(8.dp)
                ),
                iconButton = TinyPeaceIconButtonModel(
                    iconButtonColorType = TinyPeaceButtonStyleType.FilledTonal,
                    iconButtonModifier = Modifier
                        .padding(8.dp),
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {

                },
                buttonType = Material3ButtonType.IconButton,
                modifier = Modifier
                    .padding(8.dp),
                enable = true,
                text = null,
                basicIcon = TinyPeaceBasicIconModel(
                    imageVector = Icons.Default.Build,
                    description = "String",
                    modifier = Modifier
                        .padding(8.dp)
                ),
                iconButton = TinyPeaceIconButtonModel(
                    iconButtonColorType = TinyPeaceButtonStyleType.Outlined,
                    iconButtonModifier = Modifier
                        .padding(8.dp)
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
    }
}

/**
 *  @param buttonType Material3ButtonType
 *  @param enable Boolean
 *  @param iconButton TinyPeaceIconButtonModel?
 *  @param onPressInteraction TinyPeaceButtonInteraction?
 * */
class TinyPeaceButtonModel(
    var buttonType: Material3ButtonType,
    var enable: Boolean,
    var iconButton: TinyPeaceIconButtonModel?,
    var onPressInteraction: TinyPeaceButtonInteraction?

)

class TinyPeaceIconButtonModel(
    var iconButtonColorType: TinyPeaceButtonStyleType,
    var iconButtonAction: (()->Unit),
    var iconButtonModifier: Modifier,
    var tpBasicIcon: TinyPeaceBasicIconModel
)

