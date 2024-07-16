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
import com.example.tinypeace.components.buttons.TinyPeaceButtons
import com.example.tinypeace.components.buttons.enums.TinyPeaceButtonType
import com.example.tinypeace.components.buttons.enums.TinyPeaceIconButtonStyleType
import com.example.tinypeace.components.buttons.models.TinyPeaceBasicIconModel
import com.example.tinypeace.components.buttons.models.TinyPeaceButtonInteractionModel
import com.example.tinypeace.components.buttons.models.TinyPeaceSegmentedButtonModel

@Composable
fun IconButtonView() {
    Row {
        TinyPeaceButtons(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {

                },
                buttonType = TinyPeaceButtonType.IconButton,
                modifier = Modifier,
                enable = true,
                text = null,
                basicIcon = TinyPeaceBasicIconModel(
                    imageVector = Icons.Default.Build,
                    description = "String",
                    modifier = Modifier
                ),
                iconButton = TinyPeaceIconButtonModel(
                    iconButtonColorType = TinyPeaceIconButtonStyleType.Filled,
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
                buttonType = TinyPeaceButtonType.IconButton,
                modifier = Modifier,
                enable = true,
                text = null,
                basicIcon = TinyPeaceBasicIconModel(
                    imageVector = Icons.Default.Build,
                    description = "String",
                    modifier = Modifier
                ),
                iconButton = TinyPeaceIconButtonModel(
                    iconButtonColorType = TinyPeaceIconButtonStyleType.Regular,
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
                buttonType = TinyPeaceButtonType.IconButton,
                modifier = Modifier,
                enable = true,
                text = null,
                basicIcon = TinyPeaceBasicIconModel(
                    imageVector = Icons.Default.Build,
                    description = "String",
                    modifier = Modifier
                ),
                iconButton = TinyPeaceIconButtonModel(
                    iconButtonColorType = TinyPeaceIconButtonStyleType.FilledTonal,
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
                buttonType = TinyPeaceButtonType.IconButton,
                modifier = Modifier,
                enable = true,
                text = null,
                basicIcon = TinyPeaceBasicIconModel(
                    imageVector = Icons.Default.Build,
                    description = "String",
                    modifier = Modifier
                ),
                iconButton = TinyPeaceIconButtonModel(
                    iconButtonColorType = TinyPeaceIconButtonStyleType.Outlined,
                    iconButtonModifier = Modifier,
                ),
                segmentedButton = null,
                onPressInteraction = null
            )
        )
    }
}

/**
 *  @param T Generic for segmented button: use nullable if not using segmented button.
 *  @param buttonType TinyPeaceButtonType
 *  @param enable Boolean
 *  @param iconButton TinyPeaceIconButtonModel?
 *  @param onPressInteraction TinyPeaceButtonInteractionModel?
 * */
class TinyPeaceButtonModel<T>(
    var action: () -> Unit,
    var buttonType: TinyPeaceButtonType,
    var modifier: Modifier,
    var enable: Boolean,
    var text: TinyPeaceButtonTextModel?,
    var basicIcon: TinyPeaceBasicIconModel?,
    var iconButton: TinyPeaceIconButtonModel?,
    var segmentedButton: TinyPeaceSegmentedButtonModel<T>?,
    var onPressInteraction: TinyPeaceButtonInteractionModel?

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
    var iconButtonColorType: TinyPeaceIconButtonStyleType,
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
fun returnIconButtonColor(iconButtonColorType: TinyPeaceIconButtonStyleType): IconButtonColors {
    return when (iconButtonColorType) {
        TinyPeaceIconButtonStyleType.Regular -> {
            IconButtonDefaults.iconButtonColors()
        }
        TinyPeaceIconButtonStyleType.Filled-> {
            IconButtonDefaults.filledIconButtonColors()
        }
        TinyPeaceIconButtonStyleType.Outlined -> {
            IconButtonDefaults.outlinedIconButtonColors()
        }
        TinyPeaceIconButtonStyleType.FilledTonal -> {
            IconButtonDefaults.filledTonalIconButtonColors()
        }
    }
}
