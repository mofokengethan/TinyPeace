package com.example.tinypeace.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonDefaults.containerColor
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tinypeace.components.TinyPeaceButtonModel
import com.example.tinypeace.components.buttons.enums.TinyPeaceButtonType
import com.example.tinypeace.components.buttons.enums.TinyPeaceIconButtonStyleType
import com.example.tinypeace.components.buttons.enums.TinyPeaceSegmentedButtonType
import com.example.tinypeace.components.buttons.models.TinyPeaceButtonStylesModel
import com.example.tinypeace.components.returnIconButtonColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> TinyPeaceButtons(
    tinyPeaceButtonModel: TinyPeaceButtonModel<T>
) {

    val interactionSource = remember { MutableInteractionSource() }
    val scope = rememberCoroutineScope()

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
                    /**
                     * If the users drags their finger outside the button, then lifts their finger,
                     * the button generates Cancel interaction, to indicate that the press was canceled */
                    is PressInteraction.Cancel -> {
                        tinyPeaceButtonModel.onPressInteraction?.onCancelInteraction?.invoke()
                    }
                }
            }
        }
    }

    when (tinyPeaceButtonModel.buttonType) {
        TinyPeaceButtonType.ExtendedFloatingActionButton -> {
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
        TinyPeaceButtonType.FloatingActionButton -> {
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
        TinyPeaceButtonType.FilledButton -> {
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
        TinyPeaceButtonType.FilledTonalButton -> {
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
        TinyPeaceButtonType.ElevatedButton -> {
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
        TinyPeaceButtonType.OutlinedButton -> {
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
        TinyPeaceButtonType.TextButton -> {
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
        TinyPeaceButtonType.SegmentedButton -> {
            tinyPeaceButtonModel.segmentedButton?.let { button ->
                when (button.segmentedButtonType) {
                    TinyPeaceSegmentedButtonType.SingleChoiceSegmentedButton -> {
                        SingleChoiceSegmentedButtonRow {
                            button.options.forEachIndexed { index, _ ->
                                SegmentedButton(selected = index in button.checkedList,
                                    onClick = {
                                        if (index in button.checkedList) {
                                            button.checkedList.remove(index)
                                        } else {
                                            button.checkedList.clear()
                                            button.checkedList.add(index)
                                        }
                                        tinyPeaceButtonModel.action.invoke()
                                        println(button.options[index].toString())
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
                                            contentDescription = button.icons[index].name
                                        )
                                    },
                                    label = {
                                        Text(button.options[index].toString())
                                    }
                                )
                            }
                        }
                    }
                    TinyPeaceSegmentedButtonType.MultiChoiceSegmentedButton -> {
                        MultiChoiceSegmentedButtonRow {
                            button.options.forEachIndexed { index, _ ->
                                SegmentedButton(
                                    shape = SegmentedButtonDefaults.itemShape(index = index, count = button.options.size),
                                    icon = {
                                            Icon(
                                                imageVector = button.icons[index],
                                                contentDescription = button.icons[index].name
                                            )
                                    },
                                    onCheckedChange = { // on click for multi choice segmented button row
                                        if (index in button.checkedList) {
                                            button.checkedList.remove(index)
                                        } else {
                                            button.checkedList.add(index)
                                        }
                                        tinyPeaceButtonModel.action.invoke()
                                        println(button.options[index].toString())
                                    },
                                    checked = index in button.checkedList,
                                    border = BorderStroke(2.dp, Color.Black),
                                    label = { Text(text = button.options[index].toString()) }
                                )
                            }
                        }
                    }
                }
            }
        }
        TinyPeaceButtonType.IconButton -> {
            tinyPeaceButtonModel.iconButton?.let { button ->
                if (button.iconButtonColorType == TinyPeaceIconButtonStyleType.Outlined) {
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
fun returnDefaultButtonStyles(buttonType: TinyPeaceButtonType): TinyPeaceButtonStylesModel {
    val m3ButtonStyle = TinyPeaceButtonStylesModel()
     when (buttonType) {
        TinyPeaceButtonType.ExtendedFloatingActionButton -> {
            return m3ButtonStyle
        }
        TinyPeaceButtonType.FloatingActionButton -> {
            return m3ButtonStyle
        }
        TinyPeaceButtonType.FilledButton -> {
            m3ButtonStyle.shape = ButtonDefaults.shape
            m3ButtonStyle.colors = ButtonDefaults.buttonColors()
            m3ButtonStyle.elevation = null
            m3ButtonStyle.border = null
            return m3ButtonStyle
        }
        TinyPeaceButtonType.FilledTonalButton -> {
            m3ButtonStyle.shape = ButtonDefaults.filledTonalShape
            m3ButtonStyle.colors = ButtonDefaults.filledTonalButtonColors()
            m3ButtonStyle.elevation = null
            m3ButtonStyle.border = null
            return m3ButtonStyle
        }
        TinyPeaceButtonType.ElevatedButton -> {
            m3ButtonStyle.shape = ButtonDefaults.elevatedShape
            m3ButtonStyle.colors = ButtonDefaults.elevatedButtonColors()
            m3ButtonStyle.elevation = ButtonDefaults.elevatedButtonElevation()
            m3ButtonStyle.border = null
            return m3ButtonStyle
        }
        TinyPeaceButtonType.OutlinedButton -> {
            m3ButtonStyle.shape = ButtonDefaults.outlinedShape
            m3ButtonStyle.colors = ButtonDefaults.outlinedButtonColors()
            m3ButtonStyle.elevation = null
            m3ButtonStyle.border = ButtonDefaults.outlinedButtonBorder
            return m3ButtonStyle
        }
        TinyPeaceButtonType.TextButton -> {
            m3ButtonStyle.shape = ButtonDefaults.textShape
            m3ButtonStyle.colors = ButtonDefaults.textButtonColors()
            m3ButtonStyle.elevation = null
            m3ButtonStyle.border = null
            return m3ButtonStyle
        }
        TinyPeaceButtonType.SegmentedButton -> {
            return m3ButtonStyle
        }
        TinyPeaceButtonType.IconButton -> {
            return m3ButtonStyle
        }
    }
}
