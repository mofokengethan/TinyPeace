package com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums

/**
 * # TinyPeaceButtonType
 *
 * **Material Design Button Types**
 *
 * *For more details, visit: [Material Buttons](https://m3.material.io/components/all-buttons)*
 *
 * [Buttons Image](https://firebasestorage.googleapis.com/v0/b/design-spec/o/projects%2Fgoogle-material-3%2Fimages%2Flvlz8hsu-1.png?alt=media&token=1016fa7e-c51c-4bbd-99ca-e22dcf21e0ad)
 *
 * ## Enum Values
 *
 * ### High Emphasis
 * - ***ExtendedFloatingActionButton***: (9) - Extended FAB for more prominent actions.
 * - ***FloatingActionButton***: (8) - Default FAB for primary actions.
 * - ***FilledButton***: (2) - Prominent button for final or unblocking actions.
 *
 * ### Medium Emphasis
 * - ***FilledTonalButton***: (3) - Less prominent filled button for final actions.
 * - ***ElevatedButton***: (1) - Filled button with shadow for visual separation.
 * - ***OutlinedButton***: (4) - Button for secondary actions.
 *
 * ### Small Emphasis
 * - **TextButton**: (5) - Low prominence button for alternative options.
 * - **SegmentedButton**: (7) - More prominent than a single icon button.
 * - **IconButton**: (6) - Compact button for optional supplementary actions.
 */
enum class TinyPeaceButtonType {
    // Level of emphasis: High
    // For primary, most important, or common actions on a screen
    ExtendedFloatingActionButton, // (9)
    FloatingActionButton, // (8)
    FilledButton, // (2)

    // Level of emphasis: Medium
    // For important actions that don't distract from other onscreen elements
    FilledTonalButton, // (3)
    ElevatedButton, // (1)
    OutlinedButton, // (4)

    // Level of emphasis: Small
    // For optional or supplementary actions with the least amount of prominence
    TextButton, // (5)
    SegmentedButton, // (7)
    IconButton, // (6)
}