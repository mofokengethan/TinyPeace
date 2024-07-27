package com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.model

import androidx.compose.ui.Modifier
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.iconData.IconViewModel

class AppBarModel(
    var hasNavigationIcon: IconViewModel? = null,
    var hasActions: Pair<IconViewModel?, IconViewModel?>?,
    var hasMenuOption: IconViewModel? = null,
    var bottomBarBadges: List<IconViewModel>? = null,
    var hasFloatingAction: IconViewModel? = null,
    var modifier: Modifier
)
