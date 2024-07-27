package com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation

class TinyPeaceInputFieldsModel(
    var textStyle: TextStyle,
    var labelsAndIcons: TinyPeaceInputFieldLabelsAndIcons?,
    var visualTransformation: VisualTransformation,
    var keyboardOptions: TinyPeaceKeyboardOptionsModel,
    var keyboardActions: TinyPeaceKeyboardActionsModel,
)