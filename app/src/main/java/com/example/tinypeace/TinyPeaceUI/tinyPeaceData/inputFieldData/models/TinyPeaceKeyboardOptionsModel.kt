package com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models

import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PlatformImeOptions

class TinyPeaceKeyboardOptionsModel(
    var capitalization: KeyboardCapitalization,
    var autoCorrect: Boolean,
    var keyboardType: KeyboardType,
    var imeAction: ImeAction,
    var platformImeOptions: PlatformImeOptions?
)