package com.example.tinypeace.TinyPeaceUI.homeScreen

import androidx.annotation.Nullable
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Button
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonTextModel
import com.example.tinypeace.TinyPeaceUI.homeScreen.enums.ComponentViewTypes

@Composable
fun ViewTypeRow(unit: (ComponentViewTypes) -> Unit) {
    var selectedView by remember { mutableStateOf(ComponentViewTypes.TopBars) }
    val componentViews = listOf(
        "Top Bars",
        "Bottom Bars",
        "Buttons",
        "Communications",
        "Cards",
        "Dialogs",
        "Input Fields",
        "Progress Indicator",
    )

    LazyRow {
        componentViews.forEach { component ->
            item {
                TP_Button(tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                    action = {
                        when (component) {
                            "Progress Indicator" -> {
                                selectedView = ComponentViewTypes.ProgressIndicators
                                unit(selectedView)
                            }
                            "Top Bars" -> {
                                selectedView = ComponentViewTypes.TopBars
                                unit(selectedView)
                            }
                            "Bottom Bars" -> {
                                selectedView = ComponentViewTypes.BottomBars
                                unit(selectedView)
                            }
                            "Buttons" -> {
                                selectedView = ComponentViewTypes.Buttons
                                unit(selectedView)
                            }
                            "Communications" -> {
                                selectedView = ComponentViewTypes.Communications
                                unit(selectedView)
                            }
                            "Cards" -> {
                                selectedView = ComponentViewTypes.Cards
                                unit(selectedView)
                            }
                            "Dialogs" -> {
                                selectedView = ComponentViewTypes.Dialogs
                                unit(selectedView)
                            }
                            "Input Fields" -> {
                                selectedView = ComponentViewTypes.InputFields
                                unit(selectedView)
                            }
                        }
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
}