package com.example.tinypeace.components

import androidx.annotation.Nullable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun IconButtonView() {
    Row {
        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {

                },
                buttonType = Material3ButtonType.IconButton,
                modifier = Modifier,
                enable = true,
                text = null,
                basicIcon = TinyPeaceBasicIconModel(
                    imageVector = Icons.Default.Build,
                    description = "String",
                    modifier = Modifier
                ),
                iconButton = TinyPeaceIconButtonModel(
                    iconButtonColorType = TinyPeaceButtonStyleType.Filled,
                    iconButtonModifier = Modifier,
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {

                },
                buttonType = Material3ButtonType.IconButton,
                modifier = Modifier,
                enable = true,
                text = null,
                basicIcon = TinyPeaceBasicIconModel(
                    imageVector = Icons.Default.Build,
                    description = "String",
                    modifier = Modifier
                ),
                iconButton = TinyPeaceIconButtonModel(
                    iconButtonColorType = TinyPeaceButtonStyleType.Regular,
                    iconButtonModifier = Modifier,
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {

                },
                buttonType = Material3ButtonType.IconButton,
                modifier = Modifier,
                enable = true,
                text = null,
                basicIcon = TinyPeaceBasicIconModel(
                    imageVector = Icons.Default.Build,
                    description = "String",
                    modifier = Modifier
                ),
                iconButton = TinyPeaceIconButtonModel(
                    iconButtonColorType = TinyPeaceButtonStyleType.FilledTonal,
                    iconButtonModifier = Modifier
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {

                },
                buttonType = Material3ButtonType.IconButton,
                modifier = Modifier,
                enable = true,
                text = null,
                basicIcon = TinyPeaceBasicIconModel(
                    imageVector = Icons.Default.Build,
                    description = "String",
                    modifier = Modifier
                ),
                iconButton = TinyPeaceIconButtonModel(
                    iconButtonColorType = TinyPeaceButtonStyleType.Outlined,
                    iconButtonModifier = Modifier,
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
    }
}

/**
 *  @param buttonType Material3ButtonType
 *  @param enable Boolean
 *  @param iconButton TinyPeaceIconButtonModel?
 *  @param onPressInteraction TinyPeaceButtonInteraction?
 * */
class TinyPeaceButtonModel<T>(
    var action: () -> Unit,
    var buttonType: Material3ButtonType,
    var modifier: Modifier,
    var enable: Boolean,
    var text: TinyPeaceButtonTextModel?,
    var basicIcon: TinyPeaceBasicIconModel?,
    var iconButton: TinyPeaceIconButtonModel?,
    var segmentedButton: TinyPeaceSegmentedButtonModel<T>?,
    var onPressInteraction: TinyPeaceButtonInteraction?

)

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


class TinyPeaceIconButtonModel(
    var iconButtonColorType: TinyPeaceButtonStyleType,
    var iconButtonModifier: Modifier
)


/**
 * This function returns IconButtonColors based on the
 * parameter, which is an enum including:
 *
 * - Regular, Filled, Outlined, and FilledTonal button colors
 *
 * @param iconButtonColorType IconButtonColorType
 * @return IconButtonColors IconButtonDefaults colors
 */
@Composable
fun returnIconButtonColor(iconButtonColorType: TinyPeaceButtonStyleType): IconButtonColors {
    return when (iconButtonColorType) {
        TinyPeaceButtonStyleType.Regular -> {
            IconButtonDefaults.iconButtonColors()
        }
        TinyPeaceButtonStyleType.Filled-> {
            IconButtonDefaults.filledIconButtonColors()
        }
        TinyPeaceButtonStyleType.Outlined -> {
            IconButtonDefaults.outlinedIconButtonColors()
        }
        TinyPeaceButtonStyleType.FilledTonal -> {
            IconButtonDefaults.filledTonalIconButtonColors()
        }
    }
}
