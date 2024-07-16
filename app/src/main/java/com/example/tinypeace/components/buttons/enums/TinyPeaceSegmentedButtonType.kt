package com.example.tinypeace.components.buttons.enums

/**
 * # TinyPeaceSegmentedButtonType
 *
 * **Material Design Button Types**
 *
 * *For more details, visit: [Material Buttons](https://m3.material.io/components/all-buttons)*
 *
 * [Buttons Image](https://firebasestorage.googleapis.com/v0/b/design-spec/o/projects%2Fgoogle-material-3%2Fimages%2Flvlz8hsu-1.png?alt=media&token=1016fa7e-c51c-4bbd-99ca-e22dcf21e0ad)
 *
 * Segmented buttons can have 2-5 segments. Each segment is clearly divided and contains label text, an icon, or both.
 *
 * ## Enum Values
 *
 * - **MultiChoiceSegmentedButton**: Multi-select segmented button can have multiple segments selected.
 * - **SingleChoiceSegmentedButton**: Single-select segmented button can only have 1 segment selected.
 */
enum class TinyPeaceSegmentedButtonType {
    MultiChoiceSegmentedButton, // (7)
    SingleChoiceSegmentedButton // Example not included in Buttons Image link
}