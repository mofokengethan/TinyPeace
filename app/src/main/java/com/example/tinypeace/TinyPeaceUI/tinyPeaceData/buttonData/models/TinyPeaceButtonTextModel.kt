package com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models

import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

class TinyPeaceButtonTextModel(
    var text: String,
    var style: TextStyle,
    var textAlign: TextAlign,
    var modifier: Modifier,
    var softWrap: Boolean,
    var maxLines: Int,
    var minLines: Int,
    var lineHeight: TextUnit,
    var letterSpacing: TextUnit
)
