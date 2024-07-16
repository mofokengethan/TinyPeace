package com.example.tinypeace.components.buttons.models

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Model class for defining an icon in Jetpack Compose.
 *
 * This class encapsulates properties necessary to display an icon.
 *
 * @param imageVector The vector asset representing the icon.
 * @param description Description for the icon, used for accessibility purposes.
 * @param modifier Modifier for styling and positioning the icon.
 *
 * val iconModel = TinyPeaceBasicIconModel(
 *     imageVector = Icons.Default.Favorite, // Define the vector asset for the icon
 *     description = "Favorite Icon", // Provide a description for accessibility
 *     modifier = Modifier.size(24.dp) // Apply a size modifier to the icon
 * )
 */
class TinyPeaceBasicIconModel(
    var imageVector: ImageVector,
    var description: String,
    var modifier: Modifier
)