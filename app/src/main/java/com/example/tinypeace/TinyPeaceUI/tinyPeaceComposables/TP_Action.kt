package com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceInteractionModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.iconData.IconViewModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceViews.ActionsView
import kotlinx.coroutines.launch

enum class TinyPeaceSmallComponentEnum {
    Switch,
    RadioButton,
    Checkbox
}

@Composable
fun TP_Action(
    communicationType: TinyPeaceSmallComponentEnum,
    isEnabled: Boolean,
    modifier: Modifier,
    switchIcon: IconViewModel?,
    onPressInteraction: TinyPeaceInteractionModel?,
) {
    val checked by remember { mutableStateOf(true) }
    val interactionSource = remember { MutableInteractionSource() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(interactionSource) {
        scope.launch {
            interactionSource.interactions.collect { interaction ->
                when (interaction) {
                    /** When a user touches a button, the button generates Press interaction */
                    /** When a user touches a button, the button generates Press interaction */
                    /** When a user touches a button, the button generates Press interaction */
                    /** When a user touches a button, the button generates Press interaction */
                    is PressInteraction.Press -> {
                        onPressInteraction?.onPressInteraction?.invoke()
                    }
                    /** If the user lifts their finger inside the button, it generates a Release interaction,
                     * letting the button know that the click was finished */
                    /** If the user lifts their finger inside the button, it generates a Release interaction,
                     * letting the button know that the click was finished */
                    /** If the user lifts their finger inside the button, it generates a Release interaction,
                     * letting the button know that the click was finished */
                    /** If the user lifts their finger inside the button, it generates a Release interaction,
                     * letting the button know that the click was finished */
                    is PressInteraction.Release -> {
                        onPressInteraction?.onReleaseInteraction?.invoke()
                    }
                    /**
                     * If the users drags their finger outside the button, then lifts their finger,
                     * the button generates Cancel interaction, to indicate that the press was canceled */
                    /**
                     * If the users drags their finger outside the button, then lifts their finger,
                     * the button generates Cancel interaction, to indicate that the press was canceled */
                    /**
                     * If the users drags their finger outside the button, then lifts their finger,
                     * the button generates Cancel interaction, to indicate that the press was canceled */
                    /**
                     * If the users drags their finger outside the button, then lifts their finger,
                     * the button generates Cancel interaction, to indicate that the press was canceled */
                    is PressInteraction.Cancel -> {
                        onPressInteraction?.onCancelInteraction?.invoke()
                    }
                }
            }
        }
    }

    when (communicationType) {
        TinyPeaceSmallComponentEnum.Switch -> {
            // TODO - switch colors have check, unchecked, disabled-checked, disable-unchecked
            // each can be modified to change thumb, track, border, and icon
            Switch(
                checked = checked,
                onCheckedChange = onPressInteraction?.tpOnCheckChange,
                modifier = modifier,
                enabled = isEnabled,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                    checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                    uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                    uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                ),
                thumbContent = {
                    switchIcon?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = viewModel)
                    }
                },
                interactionSource = interactionSource
            )
        }

        TinyPeaceSmallComponentEnum.RadioButton -> {
            // TODO - radio button colors have unselected, selected, disabled-selected, and disabled-unselected
            RadioButton(
                selected = checked,
                onClick = onPressInteraction?.tpOnClick,
                modifier = modifier,
                enabled = isEnabled,
                colors = RadioButtonDefaults.colors(),
                interactionSource = interactionSource
            )
        }

        TinyPeaceSmallComponentEnum.Checkbox -> {
            // TODO - checkbox colors have checked, unchecked, checkmark color, and disabled
            // disabled consist of checked, unchecked, indeterminate
            Checkbox(
                checked = checked,
                onCheckedChange = onPressInteraction?.tpOnCheckChange,
                modifier = modifier,
                enabled = isEnabled,
                colors = CheckboxDefaults.colors(),
                interactionSource = interactionSource
            )
        }
    }
}

@Preview(showBackground=true)
@Composable
fun TP_ActionPreview() {
    ActionsView()
}