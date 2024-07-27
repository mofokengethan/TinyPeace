package com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models

import androidx.compose.runtime.Composable

class TinyPeaceInputFieldLabelsAndIcons(
    var label: @Composable() (() -> Unit)? = null,
    var placeholder: @Composable() (() -> Unit)? = null,
    var leadingIcon: @Composable() (() -> Unit)? = null,
    var trailingIcon: @Composable() (() -> Unit)? = null,
    var prefix: @Composable() (() -> Unit)? = null,
    var suffix: @Composable() (() -> Unit)? = null,
    var supportingText: @Composable() (() -> Unit)? = null,
)