package com.example.tinypeace.TinyPeaceUI.tinyPeaceViews

import androidx.annotation.Nullable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Button
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonTextModel

@Composable
fun ExampleCardContent(
    title: String,
    subtitle: String
) {
    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        Text(text = title,style= MaterialTheme.typography.bodyMedium)
        Text(text=subtitle, style = MaterialTheme.typography.bodyLarge)
        Text(
            text="\n" +
                    "Sure, here it is:\n"  +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi.",
            style = MaterialTheme.typography.bodySmall
        )
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            TP_Button(
                tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                    action = {
                        println("Button")
                    },
                    buttonType = TinyPeaceButtonType.FilledButton,
                    modifier = Modifier,
                    enable = true,
                    text = TinyPeaceButtonTextModel(
                        text = "Continue",
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
                    modifier = Modifier.padding(horizontal = 8.dp),
                    enable = true,
                    basicIcon = null,
                    iconButton = null,
                    text = TinyPeaceButtonTextModel(
                        text = "Cancel",
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier,
                        softWrap = true,
                        maxLines = Int.MAX_VALUE,
                        minLines = 1,
                        lineHeight = TextUnit.Unspecified,
                        letterSpacing = 1.sp,
                    ),
                    segmentedButton = null,
                    onPressInteraction = null
                )
            )
        }
    }
}

@Composable
fun DialogCardContent(
    title: String,
    subtitle: String,
    dismiss: () -> Unit
) {
    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        Text(text = title,style= MaterialTheme.typography.bodyMedium)
        Text(text=subtitle, style = MaterialTheme.typography.bodyLarge)
        Text(
            text="\n" +
                    "Sure, here it is:\n"  +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi.",
            style = MaterialTheme.typography.bodySmall
        )
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            TP_Button(
                tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                    action = {
                        println("Button")
                        dismiss()
                    },
                    buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.FilledButton,
                    modifier = Modifier,
                    enable = true,
                    text = TinyPeaceButtonTextModel(
                        text = "Continue",
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
}