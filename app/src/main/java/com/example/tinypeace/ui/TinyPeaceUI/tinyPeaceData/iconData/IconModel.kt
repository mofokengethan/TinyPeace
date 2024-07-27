package com.example.tinypeace.TinyPeaceUI.tinyPeaceData.iconData

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

class IconModel (
    var showIcon: Boolean,
    var isClickable: Pair<Boolean, (()->Unit)?>,
    var imageVector: ImageVector,
    var modifier: Modifier,
)