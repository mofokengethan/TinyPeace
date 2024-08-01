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

class ActionModel(
    var type: TinyPeaceSmallComponentEnum,
    var isEnabled: Boolean,
    var modifier: Modifier,
    var hasSwitchIcon: Pair<Boolean, IconViewModel>?,
    var interaction: TinyPeaceInteractionModel?
)

@Composable
fun TP_Action(
    model: ActionModel,
    isChecked: Boolean,
) {
    val checked by remember { mutableStateOf(isChecked) }
    val interactionSource = remember { MutableInteractionSource() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(interactionSource) {
        scope.launch {
            interactionSource.interactions.collect { interaction ->
                when (interaction) {
                    /** When a user touches a button, the button generates Press interaction */
                    is PressInteraction.Press -> {
                        model.interaction?.onPressInteraction?.invoke()
                    }
                    /** If the user lifts their finger inside the button, it generates a Release interaction,
                     * letting the button know that the click was finished */
                    is PressInteraction.Release -> {
                        model.interaction?.onReleaseInteraction?.invoke()
                    }
                    /**
                     * If the users drags their finger outside the button, then lifts their finger,
                     * the button generates Cancel interaction, to indicate that the press was canceled */
                    is PressInteraction.Cancel -> {
                        model.interaction?.onCancelInteraction?.invoke()
                    }
                }
            }
        }
    }

    when (model.type) {
        TinyPeaceSmallComponentEnum.Switch -> {
            // TODO - switch colors have check, unchecked, disabled-checked, disable-unchecked
            Switch(
                checked = checked,
                onCheckedChange = model.interaction?.tpOnCheckChange,
                modifier = model.modifier,
                enabled = model.isEnabled,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                    checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                    uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                    uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                ),
                thumbContent = {
                    model.hasSwitchIcon?.let { switchIcon ->
                        if (switchIcon.first) {
                            TP_Icon(viewModel = switchIcon.second)
                        }
                    }
                },
                interactionSource = interactionSource
            )
        }

        TinyPeaceSmallComponentEnum.RadioButton -> {
            // TODO - radio button colors have unselected, selected, disabled-selected, and disabled-unselected
            RadioButton(
                selected = checked,
                onClick = model.interaction?.tpOnClick,
                modifier = model.modifier,
                enabled = model.isEnabled,
                colors = RadioButtonDefaults.colors(),
                interactionSource = interactionSource
            )
        }

        TinyPeaceSmallComponentEnum.Checkbox -> {
            // TODO - checkbox colors have checked, unchecked, checkmark color, and disabled
            Checkbox(
                checked = checked,
                onCheckedChange = model.interaction?.tpOnCheckChange,
                modifier = model.modifier,
                enabled = model.isEnabled,
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