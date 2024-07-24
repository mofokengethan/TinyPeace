package com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.functions

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonStylesModel

@Composable
fun returnIconButtonColor(iconButtonColorType: com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceIconButtonStyleType): IconButtonColors {
    return when (iconButtonColorType) {
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceIconButtonStyleType.Regular -> {
            IconButtonDefaults.iconButtonColors()
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceIconButtonStyleType.Filled-> {
            IconButtonDefaults.filledIconButtonColors()
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceIconButtonStyleType.Outlined -> {
            IconButtonDefaults.outlinedIconButtonColors()
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceIconButtonStyleType.FilledTonal -> {
            IconButtonDefaults.filledTonalIconButtonColors()
        }
    }
}


@Composable
fun returnDefaultButtonStyles(buttonType: com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType): TinyPeaceButtonStylesModel {
    val m3ButtonStyle = TinyPeaceButtonStylesModel()
    when (buttonType) {
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.ExtendedFloatingActionButton -> {
            return m3ButtonStyle
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.FloatingActionButton -> {
            return m3ButtonStyle
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.FilledButton -> {
            m3ButtonStyle.shape = ButtonDefaults.shape
            m3ButtonStyle.colors = ButtonDefaults.buttonColors()
            m3ButtonStyle.elevation = null
            m3ButtonStyle.border = null
            return m3ButtonStyle
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.FilledTonalButton -> {
            m3ButtonStyle.shape = ButtonDefaults.filledTonalShape
            m3ButtonStyle.colors = ButtonDefaults.filledTonalButtonColors()
            m3ButtonStyle.elevation = null
            m3ButtonStyle.border = null
            return m3ButtonStyle
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.ElevatedButton -> {
            m3ButtonStyle.shape = ButtonDefaults.elevatedShape
            m3ButtonStyle.colors = ButtonDefaults.elevatedButtonColors()
            m3ButtonStyle.elevation = ButtonDefaults.elevatedButtonElevation()
            m3ButtonStyle.border = null
            return m3ButtonStyle
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.OutlinedButton -> {
            m3ButtonStyle.shape = ButtonDefaults.outlinedShape
            m3ButtonStyle.colors = ButtonDefaults.outlinedButtonColors()
            m3ButtonStyle.elevation = null
            m3ButtonStyle.border = ButtonDefaults.outlinedButtonBorder
            return m3ButtonStyle
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.TextButton -> {
            m3ButtonStyle.shape = ButtonDefaults.textShape
            m3ButtonStyle.colors = ButtonDefaults.textButtonColors()
            m3ButtonStyle.elevation = null
            m3ButtonStyle.border = null
            return m3ButtonStyle
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.SegmentedButton -> {
            return m3ButtonStyle
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.IconButton -> {
            return m3ButtonStyle
        }
    }
}
