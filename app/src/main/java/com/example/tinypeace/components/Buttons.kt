package com.example.tinypeace.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonDefaults.containerColor
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

enum class Material3ButtonType {
    // https://m3.material.io/components/all-buttons
    // Image link for buttons with corresponding (numbers)
    // - https://firebasestorage.googleapis.com/v0/b/design-spec/o/projects%2Fgoogle-material-3%2Fimages%2Flvlz8hsu-1.png?alt=media&token=1016fa7e-c51c-4bbd-99ca-e22dcf21e0ad
    // Level of emphasis: High
    // For primary, most important, or common actions on a screen
    /**
     * Extended FAB: wider format and text label gives it
     * more visual prominence than a FAB. It's often used on
     * larger screens where a FAB would seem too small.
     * */
    ExtendedFloatingActionButton, // (9)
    /**
     * Floating Action Button: remains the default component fot a screen's
     * primary action. It comes in three sizes: small FAB,
     * FAB, and large FAB.
     * */
    FloatingActionButton, // (8)
    /**
     * Filled Button: contrasting surface color makes
     * it the most prominent button after the FAB. It's used
     * for final or unblocking actions in a flow.
     * */
    FilledButton, // (2)
    // Level of emphasis: Medium
    // For important actions that don't distract from other onscreen elements
    /**
     * Filled Tonal Button: have a lighter background color and
     * darker label color, making them less visually prominent
     * than a regular, filled button. They’re still used for
     * final or unblocking actions in a flow, but do so with
     * less emphasis.
     * */
    FilledTonalButton, // (3)
    /**
     * Elevated Button: essentially filled buttons with
     * a lighter background color and a shadow. To prevent
     * shadow creep, only use them when absolutely necessary,
     * such as when the button requires visual separation
     * from a patterned background.
     * */
    ElevatedButton, // (1)
    /**
     * Outlined Button: Use an outlined button for actions that need attention
     * but aren’t the primary action, such as See all or
     * Add to cart. This is also the button to use for
     * giving someone the opportunity to change their
     * mind or escape a flow.
     * */
    OutlinedButton, // (4)
    // Level of emphasis: Small
    // For optional or supplementary actions with the least amount of prominence
    /**
     * Text Button: Text buttons have less visual prominence,
     * so should be used for low emphasis actions, such as
     * alternative options. */
    TextButton, // (5)
    /**
     * Segmented Button: Segmented buttons have more visual
     * prominence than a single icon button */
    SegmentedButton, // (7)
    /**
     * Icon Button: The most compact and subtle type of button,
     * icon buttons are used for optional supplementary actions
     * as "Bookmark" or "Star" */
    IconButton, // (6)
}

enum class TinyPeaceButtonStyleType {
    Regular,
    Filled,
    Outlined,
    FilledTonal,
}

class TinyPeaceButtonInteraction(
    tpPressInteraction: (()->Unit)?,
    tpCancelInteraction: (()->Unit)?,
    tpReleaseInteraction: (()->Unit)?,
) {
    var onPressInteraction: (()->Unit)? = tpPressInteraction
    var onCancelInteraction: (()->Unit)? = tpCancelInteraction
    var onReleaseInteraction: (()->Unit)? = tpReleaseInteraction
}


class TinyPeaceBasicIconModel(
    var imageVector: ImageVector,
    var description: String,
    var modifier: Modifier
)

enum class Material3SegmentedButtonType {
    MultiChoiceSegmentedButton,
    SingleChoiceSegmentedButton
}

class TinyPeaceSegmentedButtonModel<T>(
    var segmentedButtonType: Material3SegmentedButtonType,
    var checkedList: SnapshotStateList<Int>,
    var options: List<T>,
    var icons: List<ImageVector>
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> TinyPeaceButtons(
    tinyPeaceButtonModel: TinyPeaceButtonModel<T>
) {

    val interactionSource = remember { MutableInteractionSource() }
    val scope = rememberCoroutineScope()

    val checkedList = remember { mutableStateListOf<Int>() }
    val options = listOf("Favorites", "Trending", "Saved")
    val icons =
        listOf(
            Icons.Filled.StarBorder,
            Icons.AutoMirrored.Filled.TrendingUp,
            Icons.Filled.BookmarkBorder
        )

    val buttonStyle = returnDefaultButtonStyles(
        buttonType = tinyPeaceButtonModel.buttonType
    )

    LaunchedEffect(interactionSource) {
        scope.launch {
            interactionSource.interactions.collect { interaction ->
                when (interaction) {
                    /** When a user touches a button, the button generates Press interaction */
                    is PressInteraction.Press -> {
                        tinyPeaceButtonModel.onPressInteraction?.onPressInteraction?.invoke()
                    }
                    /** If the user lifts their finger inside the button, it generates a Release interaction,
                     * letting the button know that the click was finished */
                    is PressInteraction.Release -> {
                        tinyPeaceButtonModel.onPressInteraction?.onReleaseInteraction?.invoke()
                    }
                    /** If the users drags their finger outside the button, then lifts their finger,
                     * the button generates Cancel interaction, to indicate that the press was canceled */
                    is PressInteraction.Cancel -> {
                        tinyPeaceButtonModel.onPressInteraction?.onCancelInteraction?.invoke()
                    }
                }
            }
        }
    }

    when (tinyPeaceButtonModel.buttonType) {
        Material3ButtonType.ExtendedFloatingActionButton -> {
            ExtendedFloatingActionButton(
                onClick = {
                    tinyPeaceButtonModel.action.invoke()
                },
                modifier = tinyPeaceButtonModel.modifier,
                shape = FloatingActionButtonDefaults.extendedFabShape,
                containerColor = FloatingActionButtonDefaults.containerColor,
                contentColor = contentColorFor(containerColor),
                elevation = FloatingActionButtonDefaults.elevation(),
                interactionSource = interactionSource,
                content = {
                    tinyPeaceButtonModel.basicIcon?.let { icon ->
                        Icon(
                            imageVector = icon.imageVector,
                            contentDescription = icon.description,
                            modifier = icon.modifier)

                    }
                }
            )
        }
        Material3ButtonType.FloatingActionButton -> {
            FloatingActionButton(
                onClick = {
                    tinyPeaceButtonModel.action.invoke()
                },
                modifier = tinyPeaceButtonModel.modifier,
                shape  = FloatingActionButtonDefaults.shape,
                containerColor = FloatingActionButtonDefaults.containerColor,
                contentColor = contentColorFor(containerColor),
                elevation = FloatingActionButtonDefaults.elevation(),
                interactionSource = interactionSource,
                content = {
                    tinyPeaceButtonModel.basicIcon?.let { icon ->
                        Icon(
                            imageVector = icon.imageVector,
                            contentDescription = icon.description,
                            modifier = icon.modifier)

                    }
                }
            ) 
        }
        Material3ButtonType.FilledButton -> {
            Button(
                onClick = {
                    tinyPeaceButtonModel.action.invoke()
                },
                modifier = tinyPeaceButtonModel.modifier,
                enabled = tinyPeaceButtonModel.enable,
                shape = buttonStyle.shape ?: ButtonDefaults.shape,
                colors = buttonStyle.colors ?: ButtonDefaults.buttonColors(),
                elevation = buttonStyle.elevation,
                border = buttonStyle.border,
                contentPadding = ButtonDefaults.ContentPadding,
                interactionSource = interactionSource,
            ) {
                tinyPeaceButtonModel.text?.let { text ->
                    Text(
                        text = text.text,
                        style =  text.style,
                        textAlign =  text.textAlign,
                        modifier =  text.modifier,
                        softWrap =  text.softWrap,
                        maxLines =  text.maxLines,
                        minLines =  text.minLines,
                        lineHeight =  text.lineHeight,
                        letterSpacing =  text.letterSpacing,
                    )
                }
            }
        }
        Material3ButtonType.FilledTonalButton -> {
            FilledTonalButton(
                onClick = {
                    tinyPeaceButtonModel.action.invoke()
                },
                modifier = tinyPeaceButtonModel.modifier,
                enabled = tinyPeaceButtonModel.enable,
                shape = buttonStyle.shape ?: ButtonDefaults.filledTonalShape,
                colors = buttonStyle.colors ?: ButtonDefaults.filledTonalButtonColors(),
                elevation = buttonStyle.elevation,
                border = buttonStyle.border,
                contentPadding = ButtonDefaults.ContentPadding,
                interactionSource = interactionSource,
            ) {
                tinyPeaceButtonModel.text?.let { text ->
                    Text(
                        text = text.text,
                        style =  text.style,
                        textAlign =  text.textAlign,
                        modifier =  text.modifier,
                        softWrap =  text.softWrap,
                        maxLines =  text.maxLines,
                        minLines =  text.minLines,
                        lineHeight =  text.lineHeight,
                        letterSpacing =  text.letterSpacing,
                    )
                }
            }
        }
        Material3ButtonType.ElevatedButton -> {
            ElevatedButton(
                onClick = {
                    tinyPeaceButtonModel.action.invoke()
                },
                modifier = tinyPeaceButtonModel.modifier,
                enabled = tinyPeaceButtonModel.enable,
                shape = ButtonDefaults.elevatedShape,
                colors = ButtonDefaults.elevatedButtonColors(),
                elevation = ButtonDefaults.elevatedButtonElevation(),
                border = null,
                contentPadding = ButtonDefaults.ContentPadding,
                interactionSource = interactionSource,
            ) {
                tinyPeaceButtonModel.text?.let { text ->
                    Text(
                        text = text.text,
                        style =  text.style,
                        textAlign =  text.textAlign,
                        modifier =  text.modifier,
                        softWrap =  text.softWrap,
                        maxLines =  text.maxLines,
                        minLines =  text.minLines,
                        lineHeight =  text.lineHeight,
                        letterSpacing =  text.letterSpacing,
                    )
                }
            }
        }
        Material3ButtonType.OutlinedButton -> {
            OutlinedButton(
                onClick = {
                    tinyPeaceButtonModel.action.invoke()
                },
                modifier = tinyPeaceButtonModel.modifier,
                enabled = tinyPeaceButtonModel.enable,
                shape =  buttonStyle.shape ?: ButtonDefaults.outlinedShape,
                colors =  buttonStyle.colors ?: ButtonDefaults.outlinedButtonColors(),
                elevation =  buttonStyle.elevation,
                border = ButtonDefaults.outlinedButtonBorder,
                contentPadding = ButtonDefaults.ContentPadding,
                interactionSource = interactionSource,
            ) {
                tinyPeaceButtonModel.text?.let { text ->
                    Text(
                        text = text.text,
                        style =  text.style,
                        textAlign =  text.textAlign,
                        modifier =  text.modifier,
                        softWrap =  text.softWrap,
                        maxLines =  text.maxLines,
                        minLines =  text.minLines,
                        lineHeight =  text.lineHeight,
                        letterSpacing =  text.letterSpacing,
                    )
                }
            }
        }
        Material3ButtonType.TextButton -> {
            TextButton(
                onClick = {
                    tinyPeaceButtonModel.action.invoke()
                },
                modifier = tinyPeaceButtonModel.modifier,
                enabled = tinyPeaceButtonModel.enable,
                shape = ButtonDefaults.textShape,
                colors = ButtonDefaults.textButtonColors(),
                elevation = buttonStyle.elevation,
                border = buttonStyle.border,
                contentPadding = ButtonDefaults.TextButtonContentPadding,
                interactionSource = interactionSource,
            ) {
                tinyPeaceButtonModel.text?.let { text ->
                    Text(
                        text = text.text,
                        style = text.style,
                        textAlign = text.textAlign,
                        modifier = text.modifier,
                        softWrap = text.softWrap,
                        maxLines = text.maxLines,
                        minLines = text.minLines,
                        lineHeight = text.lineHeight,
                        letterSpacing = text.letterSpacing,
                    )
                }
            }
        }
        Material3ButtonType.SegmentedButton -> {
            tinyPeaceButtonModel.segmentedButton?.let { button ->
                when (button.segmentedButtonType) {
                    Material3SegmentedButtonType.MultiChoiceSegmentedButton -> {
                        MultiChoiceSegmentedButtonRow {
                            button.options.forEachIndexed { index, _ ->
                                SegmentedButton(
                                    shape = SegmentedButtonDefaults.itemShape(index = index, count = button.options.size),
                                    icon = {
                                        Icon(
                                            imageVector = button.icons[index],
                                            contentDescription = null,
                                            modifier = tinyPeaceButtonModel.modifier
                                        )
                                    },
                                    onCheckedChange = {
                                        if (index in button.checkedList) {
                                            button.checkedList.remove(index)
                                        } else {
                                            button.checkedList.add(index)
                                        }
                                    },
                                    checked = index in button.checkedList,
                                    label = { Text(text = button.options[index].toString()) }
                                )
                            }
                        }
                    }
                    Material3SegmentedButtonType.SingleChoiceSegmentedButton -> {
                        SingleChoiceSegmentedButtonRow {
                            button.options.forEachIndexed { index, label ->

                                SegmentedButton(
                                    true,
                                    onClick = {
                                        tinyPeaceButtonModel.action.invoke()
                                    },
                                    shape = SegmentedButtonDefaults.itemShape(index = index, count = button.options.size),
                                    modifier = tinyPeaceButtonModel.modifier,
                                    enabled = tinyPeaceButtonModel.enable,
                                    colors = SegmentedButtonDefaults.colors(),
                                    border = BorderStroke(1.dp, Color.Black),
                                    interactionSource = interactionSource,
                                    icon = {
                                        Icon(
                                            imageVector = button.icons[index],
                                            contentDescription = ""
                                        )
                                    },
                                    label = {
                                        Text(button.options[index].toString())
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
        Material3ButtonType.IconButton -> {
            tinyPeaceButtonModel.iconButton?.let { button ->
                if (button.iconButtonColorType == TinyPeaceButtonStyleType.Outlined) {
                    OutlinedIconButton(
                        onClick = {
                            tinyPeaceButtonModel.action.invoke()
                        },
                        modifier = button.iconButtonModifier,
                        enabled = tinyPeaceButtonModel.enable,
                        colors = returnIconButtonColor(button.iconButtonColorType),
                        interactionSource = interactionSource
                    ) {
                        tinyPeaceButtonModel.basicIcon?.let { icon ->
                            Icon(
                                imageVector = icon.imageVector,
                                contentDescription = icon.description,
                                modifier = icon.modifier)

                        }
                    }
                } else {
                    IconButton(
                        onClick = {
                            tinyPeaceButtonModel.action.invoke()
                        },
                        modifier = button.iconButtonModifier,
                        enabled = tinyPeaceButtonModel.enable,
                        colors = returnIconButtonColor(button.iconButtonColorType),
                        interactionSource = interactionSource
                    ) {
                        tinyPeaceButtonModel.basicIcon?.let { icon ->
                            Icon(
                                imageVector = icon.imageVector,
                                contentDescription = icon.description,
                                modifier = icon.modifier)

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun returnDefaultButtonStyles(buttonType: Material3ButtonType): Material3ButtonStylesModel {
    val m3ButtonStyle = Material3ButtonStylesModel()
     when (buttonType) {
        Material3ButtonType.ExtendedFloatingActionButton -> {
            return m3ButtonStyle
        }
        Material3ButtonType.FloatingActionButton -> {
            return m3ButtonStyle
        }
        Material3ButtonType.FilledButton -> {
            m3ButtonStyle.shape = ButtonDefaults.shape
            m3ButtonStyle.colors = ButtonDefaults.buttonColors()
            m3ButtonStyle.elevation = null
            m3ButtonStyle.border = null
            return m3ButtonStyle
        }
        Material3ButtonType.FilledTonalButton -> {
            m3ButtonStyle.shape = ButtonDefaults.filledTonalShape
            m3ButtonStyle.colors = ButtonDefaults.filledTonalButtonColors()
            m3ButtonStyle.elevation = null
            m3ButtonStyle.border = null
            return m3ButtonStyle
        }
        Material3ButtonType.ElevatedButton -> {
            m3ButtonStyle.shape = ButtonDefaults.elevatedShape
            m3ButtonStyle.colors = ButtonDefaults.elevatedButtonColors()
            m3ButtonStyle.elevation = ButtonDefaults.elevatedButtonElevation()
            m3ButtonStyle.border = null
            return m3ButtonStyle
        }
        Material3ButtonType.OutlinedButton -> {
            m3ButtonStyle.shape = ButtonDefaults.outlinedShape
            m3ButtonStyle.colors = ButtonDefaults.outlinedButtonColors()
            m3ButtonStyle.elevation = null
            m3ButtonStyle.border = ButtonDefaults.outlinedButtonBorder
            return m3ButtonStyle
        }
        Material3ButtonType.TextButton -> {
            m3ButtonStyle.shape = ButtonDefaults.textShape
            m3ButtonStyle.colors = ButtonDefaults.textButtonColors()
            m3ButtonStyle.elevation = null
            m3ButtonStyle.border = null
            return m3ButtonStyle
        }
        Material3ButtonType.SegmentedButton -> {
            return m3ButtonStyle
        }
        Material3ButtonType.IconButton -> {
            return m3ButtonStyle
        }
    }
}

class Material3ButtonStylesModel(
    var shape: Shape? = null,
    var colors: ButtonColors? = null,
    var elevation: ButtonElevation? = null,
    var border: BorderStroke? = null
)