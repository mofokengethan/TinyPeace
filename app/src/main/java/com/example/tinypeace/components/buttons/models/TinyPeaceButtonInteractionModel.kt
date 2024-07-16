package com.example.tinypeace.components.buttons.models

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
class TinyPeaceButtonInteractionModel(
    tpPressInteraction: (()->Unit)?,
    tpCancelInteraction: (()->Unit)?,
    tpReleaseInteraction: (()->Unit)?,
) {
    var onPressInteraction: (()->Unit)? = tpPressInteraction
    var onCancelInteraction: (()->Unit)? = tpCancelInteraction
    var onReleaseInteraction: (()->Unit)? = tpReleaseInteraction
}