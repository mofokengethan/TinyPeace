package com.example.tinypeace.screens.mainScreen.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * ViewModel for managing the current screen type in the application.
 * This ViewModel provides state management and allows switching between different screen types.
 */
class MainAppScreenViewModel : ViewModel() {
    // Private mutable state holder for the current screen type.
    // This variable can be updated within the ViewModel.
    private var _screenType = MutableStateFlow(MainAppScreenType.One)

    /**
     * Public read-only property that exposes the current screen type as a StateFlow.
     * Composables and other observers can use this to react to changes in the screen type.
     */
    val screenType: StateFlow<MainAppScreenType> get() = _screenType

    /**
     * Updates the current screen type if it is different from the new type.
     * This function ensures that the screen type is only changed if necessary, preventing redundant updates.
     *
     * @param type The current screen type before the change.
     * @param newType The new screen type to switch to.
     */
    fun changeView(type: MainAppScreenType, newType: MainAppScreenType) {
        // Check if the new type is different from the current type
        if (type != newType) {
            // Update the state with the new screen type
            _screenType.value = newType
        }
    }
}