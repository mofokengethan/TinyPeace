package com.example.tinypeace.TinyPeaceUI.tinyPeaceViews

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cookie
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Action
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TinyPeaceSmallComponentEnum
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceInteractionModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.iconData.IconModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.iconData.IconViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActionsView() {
    Column {
        Slider(state = SliderState(0f, 0, {}, 0f..1f))

        TP_Action(
            communicationType = TinyPeaceSmallComponentEnum.RadioButton,
            isEnabled = true,
            modifier = Modifier,
            switchIcon = null,
            onPressInteraction = TinyPeaceInteractionModel(
                tpOnClick = {}
            )
        )
        TP_Action(
            communicationType = TinyPeaceSmallComponentEnum.Checkbox,
            isEnabled = true,
            modifier = Modifier,
            switchIcon = null,
            onPressInteraction = TinyPeaceInteractionModel(
                tpOnCheckChange = {}
            )
        )
        TP_Action(
            communicationType = TinyPeaceSmallComponentEnum.Switch,
            isEnabled = true,
            modifier = Modifier,
            switchIcon = null,
            onPressInteraction = TinyPeaceInteractionModel(
                tpOnCheckChange = {}
            )
        )
        TP_Action(
            communicationType = TinyPeaceSmallComponentEnum.Switch,
            isEnabled = true,
            modifier = Modifier,
            switchIcon = IconViewModel(
                IconModel(
                    showIcon = true,
                    isClickable = Pair(false, null),
                    imageVector = Icons.Outlined.Cookie,
                    modifier = Modifier
                )
            ),
            onPressInteraction = TinyPeaceInteractionModel(
                tpOnCheckChange = {}
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActionsPreview() {
    ActionsView()
}
