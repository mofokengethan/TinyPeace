package com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonElevation
import androidx.compose.ui.graphics.Shape

/**
 * Model class for defining styles for a button in Jetpack Compose.
 *
 * This class encapsulates various properties that can be customized to create styled buttons.
 *
 * @property shape The shape of the button. Determines the visual appearance of its corners.
 * @property colors The colors used to paint the button in different states (enabled, pressed, disabled).
 * @property elevation The elevation of the button, determining its shadow depth.
 * @property border The border stroke applied to the button, if any.
 *
 * val buttonStyle = TinyPeaceButtonStylesModel(
 *     shape = RoundedCornerShape(8.dp),
 *     colors = ButtonDefaults.buttonColors(
 *         backgroundColor = Color.Blue,
 *         contentColor = Color.White,
 *         disabledBackgroundColor = Color.Gray,
 *         disabledContentColor = Color.LightGray
 *     ),
 *     elevation = ButtonDefaults.elevation(
 *         defaultElevation = 8.dp,
 *         pressedElevation = 16.dp
 *     ),
 *     border = BorderStroke(
 *         width = 2.dp,
 *         color = Color.Black
 *     )
 * )
 */
class TinyPeaceButtonStylesModel(
    var shape: Shape? = null,
    var colors: ButtonColors? = null,
    var elevation: ButtonElevation? = null,
    var border: BorderStroke? = null
)