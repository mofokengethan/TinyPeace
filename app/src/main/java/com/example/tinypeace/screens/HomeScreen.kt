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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.StarBorder
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
import com.example.tinypeace.components.TinyPeaceButtonModel
import com.example.tinypeace.components.TinyPeaceButtonTextModel
import com.example.tinypeace.components.buttons.TinyPeaceButtons
import com.example.tinypeace.components.TinyPeaceIconButtonModel
import com.example.tinypeace.components.buttons.enums.TinyPeaceButtonType
import com.example.tinypeace.components.buttons.enums.TinyPeaceIconButtonStyleType
import com.example.tinypeace.components.buttons.enums.TinyPeaceSegmentedButtonType
import com.example.tinypeace.components.buttons.models.TinyPeaceBasicIconModel
import com.example.tinypeace.components.buttons.models.TinyPeaceSegmentedButtonModel
import com.example.tinypeace.ui.theme.TinyPeaceTheme
import com.example.tinypeace.ui.theme.background

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
    val componentViews = listOf(
        "Buttons",
        "Communications",
        "Containers",
        "Navigation",
        "Selections",
        "InputFields"
    )

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

            LazyRow {
                componentViews.forEach { component ->
                    item {
                        TinyPeaceButtons(tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                            action = {
                                navController.navigate("$component-screen")
                            },
                            buttonType = TinyPeaceButtonType.TextButton,
                            modifier = Modifier,
                            enable = true,
                            text = TinyPeaceButtonTextModel(
                                text = component,
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Center,
                                modifier = Modifier,
                                softWrap = true,
                                maxLines = 1,
                                minLines = 1,
                                lineHeight = TextUnit.Unspecified,
                                letterSpacing = TextUnit.Unspecified
                            ),
                             basicIcon = null,
                             iconButton = null,
                             segmentedButton = null,
                             onPressInteraction = null
                            )
                        )
                    }
                }
            }

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

            Spacer(modifier = Modifier.height(16.dp))

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
                action = {
                    println("Extended Floating Action Button")
                },
                buttonType = TinyPeaceButtonType.ExtendedFloatingActionButton,
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
                    println("Floating Action Button")
                },
                buttonType = TinyPeaceButtonType.FloatingActionButton,
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
                println("Filled Button")
            },
            buttonType = TinyPeaceButtonType.FilledButton,
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
                println("Filled Tonal Button")
            },
            buttonType = TinyPeaceButtonType.FilledTonalButton,
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
                println("Elevated Button")
            },
            buttonType = TinyPeaceButtonType.ElevatedButton,
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
                println("Outlined Button")
            },
            buttonType = TinyPeaceButtonType.OutlinedButton,
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
                    println("Text Button")
                },
                buttonType = TinyPeaceButtonType.TextButton,
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
    val singleCheckList = remember { mutableStateListOf<Int>() }
    Column {
        TinyPeaceButtons(tinyPeaceButtonModel = TinyPeaceButtonModel<String> (
            action = {
                println("Segmented Button - Single Choice Segment")
            },
            buttonType = TinyPeaceButtonType.SegmentedButton,
            modifier = Modifier
                .padding(8.dp),
            enable = true,
            text = null,
            basicIcon = null,
            iconButton = null,
            segmentedButton = TinyPeaceSegmentedButtonModel(
                segmentedButtonType = TinyPeaceSegmentedButtonType.SingleChoiceSegmentedButton,
                checkedList = singleCheckList,
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
            action = {
                println("Segmented Button - Multi Choice Segment")
            },
            buttonType = TinyPeaceButtonType.SegmentedButton,
            modifier = Modifier
                .padding(8.dp),
            enable = true,
            text = null,
            basicIcon = null,
            iconButton = null,
            segmentedButton = TinyPeaceSegmentedButtonModel(
                segmentedButtonType = TinyPeaceSegmentedButtonType.MultiChoiceSegmentedButton,
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
                action = { println("Icon Button - Filled") },
                buttonType = TinyPeaceButtonType.IconButton,
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
                    iconButtonColorType = TinyPeaceIconButtonStyleType.Filled,
                    iconButtonModifier = Modifier
                        .padding(8.dp)
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = { println("Icon Button - Regular") },
                buttonType = TinyPeaceButtonType.IconButton,
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
                    iconButtonColorType = TinyPeaceIconButtonStyleType.Regular,
                    iconButtonModifier = Modifier
                        .padding(8.dp)
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = { println("Icon Button - Filled Toned") },
                buttonType = TinyPeaceButtonType.IconButton,
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
                    iconButtonColorType = TinyPeaceIconButtonStyleType.FilledTonal,
                    iconButtonModifier = Modifier
                        .padding(8.dp),
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = { println("Icon Button - Outlined") },
                buttonType = TinyPeaceButtonType.IconButton,
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
                    iconButtonColorType = TinyPeaceIconButtonStyleType.Outlined,
                    iconButtonModifier = Modifier
                        .padding(8.dp)
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
    }
}
