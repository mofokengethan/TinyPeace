package com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.ui.text.input.ImeAction

class TinyPeaceKeyboardActionsModel @OptIn(ExperimentalFoundationApi::class) constructor(
    val onDone: (KeyboardActionScope.() -> Unit)? = null,
    val onGo: (KeyboardActionScope.() -> Unit)? = null,
    val onNext: (KeyboardActionScope.() -> Unit)? = null,
    var onPrevious: (KeyboardActionScope.() -> Unit)? = null,
    var onSearch: (KeyboardActionScope.() -> Unit)? = null,
    var onSend: (KeyboardActionScope.() -> Unit)? = null,
    var onSubmit:  ((ImeAction) -> Boolean)? = null
)