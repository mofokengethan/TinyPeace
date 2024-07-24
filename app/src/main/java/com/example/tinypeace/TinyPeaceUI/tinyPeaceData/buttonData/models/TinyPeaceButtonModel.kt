package com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models

import androidx.compose.ui.Modifier
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType


class TinyPeaceButtonModel<T>(
    var action: () -> Unit,
    var buttonType: com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType,
    var modifier: Modifier,
    var enable: Boolean,
    var text: TinyPeaceButtonTextModel?,
    var basicIcon: TinyPeaceBasicIconModel?,
    var iconButton: TinyPeaceIconButtonModel?,
    var segmentedButton: TinyPeaceSegmentedButtonModel<T>?,
    var onPressInteraction: TinyPeaceInteractionModel?
)