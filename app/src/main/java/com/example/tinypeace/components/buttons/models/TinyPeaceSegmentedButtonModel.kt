package com.example.tinypeace.components.buttons.models

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.tinypeace.components.buttons.enums.TinyPeaceSegmentedButtonType

/**
 * Model class for defining a segmented button in Jetpack Compose.
 *
 * This class encapsulates properties necessary to create a segmented button, allowing single choice selection.
 *
 * @param segmentedButtonType The type of segmented button (e.g., default, outlined, etc.).
 * @param checkedList SnapshotStateList holding the index of the currently selected option.
 * @param options List of options to display as segments.
 * @param icons Optional list of icons corresponding to each option.
 *
 * val segmentedButtonModel = TinyPeaceSegmentedButtonModel(
 *     segmentedButtonType = TinyPeaceSegmentedButtonType.Default, // Define the type of segmented button
 *     checkedList = remember { mutableStateListOf(0) }, // Initialize checkedList with default selection index
 *     options = listOf("Option 1", "Option 2", "Option 3"), // Define options for the segmented button
 *     icons = listOf(
 *         Icons.Default.Home,
 *         Icons.Default.Work,
 *         Icons.Default.Favorite
 *     ) // Optionally define icons for each option
 * )
 */
class TinyPeaceSegmentedButtonModel<T>(
    var segmentedButtonType: TinyPeaceSegmentedButtonType,
    var checkedList: SnapshotStateList<Int>,
    var options: List<T>,
    var icons: List<ImageVector>
)