package com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.enums.TinyPeaceDialogsViewType

@Composable
fun TP_Dialog(
    dialogType: TinyPeaceDialogsViewType,
    modifier: Modifier,
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit,
    dismissButton: @Composable () -> Unit,
    icon: @Composable() () -> Unit,
    title: @Composable() () -> Unit,
    text: @Composable() () -> Unit,
    content: @Composable () -> Unit
) {
    when (dialogType) {
        TinyPeaceDialogsViewType.AlertDialog -> AlertDialog(
            onDismissRequest = onDismissRequest,
            confirmButton = confirmButton,
            modifier = modifier,
            dismissButton = dismissButton,
            shape = AlertDialogDefaults.shape,
            icon = icon,
            title = title,
            text = text,
            containerColor = AlertDialogDefaults.containerColor,
            iconContentColor = AlertDialogDefaults.iconContentColor,
            titleContentColor = AlertDialogDefaults.titleContentColor,
            textContentColor = AlertDialogDefaults.textContentColor,
            tonalElevation = AlertDialogDefaults.TonalElevation,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.Inherit
            )
        )
        TinyPeaceDialogsViewType.Dialog ->  Dialog(
            onDismissRequest = onDismissRequest,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.Inherit
            )
        ) {
            content()
        }
    }
}
