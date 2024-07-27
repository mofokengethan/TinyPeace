package com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models

/**
 * Represents an interaction model for a button in Jetpack Compose.
 *
 * @param tpPressInteraction
 * @param tpCancelInteraction
 * @param tpReleaseInteraction
 *
 * ### Press Interaction
 * Callback for handling press interactions.
 * Default value is the provided `tpPressInteraction` callback, if any.
 *
 *
 * ### Cancel Interaction
 * Callback for handling cancel interactions.
 * Default value is the provided `tpCancelInteraction` callback, if any.

 *
 * ### Release Interaction
 * Callback for handling release interactions.
 * Default value is the provided `tpReleaseInteraction` callback, if any.
 */
class TinyPeaceInteractionModel(
    tpPressInteraction: (()->Unit)? = null,
    tpCancelInteraction: (()->Unit)? = null,
    tpReleaseInteraction: (()->Unit)? = null,
    var tpOnClick: (()->Unit)? = null,
    var tpOnTextChange: ((String)->Unit)? = null,
    var tpOnCheckChange: ((Boolean)->Unit)? = null,
) {
    var onPressInteraction: (()->Unit)? = tpPressInteraction
    var onCancelInteraction: (()->Unit)? = tpCancelInteraction
    var onReleaseInteraction: (()->Unit)? = tpReleaseInteraction
}

class InteractionModel(
    press: (() -> Unit)? = null,
    cancel: (() -> Unit)? = null,
    release: (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
    onTextChange: ((String) -> Unit)? = null,
    onCheckChange: ((Boolean) -> Unit)? = null
)