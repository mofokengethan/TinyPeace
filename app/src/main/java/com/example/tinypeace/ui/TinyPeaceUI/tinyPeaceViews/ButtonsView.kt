package com.example.tinypeace.TinyPeaceUI.tinyPeaceViews

import androidx.annotation.Nullable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Button
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceIconButtonStyleType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceSegmentedButtonType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceBasicIconModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonTextModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceIconButtonModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceSegmentedButtonModel


@Composable
fun ButtonsView() {
   Column {
       IconButtonView()

       ButtonView()

       Button2View()

       Button3View()

       SegmentedButtonsView()
   }
}


@Composable
fun ButtonView() {
    Row {
        TP_Button(
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

        TP_Button(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {
                    println("Floating Action Button")
                },
                buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.FloatingActionButton,
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
    TP_Button(
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

    TP_Button(
        tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
            action = {
                println("Filled Tonal Button")
            },
            buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.FilledTonalButton,
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

    TP_Button(
        tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
            action = {
                println("Elevated Button")
            },
            buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.ElevatedButton,
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

    TP_Button(
        tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
            action = {
                println("Outlined Button")
            },
            buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.OutlinedButton,
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
        TP_Button(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {
                    println("Text Button")
                },
                buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.TextButton,
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
fun SegmentedButtonsView () {
    val checkedList = remember { mutableStateListOf<Int>() }
    val singleCheckList = remember { mutableStateListOf<Int>() }
    Column {
        TP_Button(tinyPeaceButtonModel = TinyPeaceButtonModel(
            action = {
                println("Segmented Button - Single Choice Segment")
            },
            buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.SegmentedButton,
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
            )
        )

        TP_Button(tinyPeaceButtonModel = TinyPeaceButtonModel(
            action = {
                println("Segmented Button - Multi Choice Segment")
            },
            buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.SegmentedButton,
            modifier = Modifier
                .padding(8.dp),
            enable = true,
            text = null,
            basicIcon = null,
            iconButton = null,
            segmentedButton = TinyPeaceSegmentedButtonModel(
                segmentedButtonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceSegmentedButtonType.MultiChoiceSegmentedButton,
                checkedList = checkedList,
                options = listOf("Favorites", "Trending", "Saved"),
                icons =  listOf(
                    Icons.Filled.StarBorder,
                    Icons.AutoMirrored.Filled.TrendingUp,
                    Icons.Filled.BookmarkBorder
                )
            ),
            onPressInteraction = null
        )
        )
    }
}

@Composable
fun IconButtonView() {
    Row {
        TP_Button(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = { println("Icon Button - Filled") },
                buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.IconButton,
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
                    iconButtonColorType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceIconButtonStyleType.Filled,
                    iconButtonModifier = Modifier
                        .padding(8.dp)
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
        TP_Button(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = { println("Icon Button - Regular") },
                buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.IconButton,
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
        TP_Button(
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
        TP_Button(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = { println("Icon Button - Outlined") },
                buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.IconButton,
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
                    iconButtonColorType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceIconButtonStyleType.Outlined,
                    iconButtonModifier = Modifier
                        .padding(8.dp)
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TP_Button_Preview() {
    ButtonsView()
}