package com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.enums.TinyPeaceDialogsViewType

class AlertDialog(
    var confirmButton: @Composable () -> Unit,
    var dismissButton: @Composable () -> Unit,
    var icon: @Composable() () -> Unit,
    var title: @Composable() () -> Unit,
    var text: @Composable() () -> Unit,
)

@Composable
fun TP_Dialog(
    dialogType: TinyPeaceDialogsViewType,
    modifier: Modifier,
    onDismissRequest: () -> Unit,
    alertDialog: AlertDialog?,
    content: @Composable () -> Unit
) {
    when (dialogType) {
        TinyPeaceDialogsViewType.AlertDialog -> {
            alertDialog?.let { dialog: AlertDialog ->
                AlertDialog(
                    onDismissRequest = onDismissRequest,
                    confirmButton = dialog.confirmButton,
                    modifier = modifier,
                    dismissButton = dialog.dismissButton,
                    shape = AlertDialogDefaults.shape,
                    icon = dialog.icon,
                    title = dialog.title,
                    text = dialog.text,
                    containerColor = AlertDialogDefaults.containerColor,
                    iconContentColor = AlertDialogDefaults.iconContentColor,
                    titleContentColor = AlertDialogDefaults.titleContentColor,
                    textContentColor = AlertDialogDefaults.textContentColor,
                    tonalElevation = AlertDialogDefaults.TonalElevation,
                    properties = DialogProperties(
                        dismissOnBackPress = true,
                        dismissOnClickOutside = true,
                        securePolicy = SecureFlagPolicy.SecureOff
                    )
                )
            }
        }
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
