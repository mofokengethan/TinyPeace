package com.example.tinypeace.TinyPeaceUI.tinyPeaceViews

import androidx.annotation.Nullable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Button
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Dialog
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Cards
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonTextModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.cardData.enums.TinyPeaceCardType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.enums.TinyPeaceDialogsViewType

@Composable
fun DialogViews() {
    var showDialog by remember { mutableStateOf(false) }
    var showAlertDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Show Dialog")
        }

        Button(onClick = { showAlertDialog = true }) {
            Text("Show Alert Dialog")
        }

        if (showDialog) {
            TP_Dialog(
                dialogType = TinyPeaceDialogsViewType.Dialog, // Replace with your specific type
                modifier = Modifier,
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Dismiss")
                    }
                },
                icon = {
                    Icon(Icons.Default.Info, contentDescription = null)
                },
                title = {
                    Text("Dialog Title")
                },
                text = {
                    Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi.")
                },
                content = {
                    // Additional content can be added here if needed
                    TP_Cards(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(16.dp),
                        tinyPeaceCardType = TinyPeaceCardType.ElevatedCard
                    ) {
                        DialogCardContent(
                            title = "Card Type",
                            subtitle = "Elevated"
                        ) {
                            showDialog = false
                        }
                    }
                }
            )
        }
        if (showAlertDialog) {
            TP_Dialog(
                dialogType = TinyPeaceDialogsViewType.AlertDialog,
                modifier = Modifier,
                onDismissRequest = { showAlertDialog = false },
                confirmButton = { TP_Button(
                    tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                        action = {
                            println("Button")
                        },
                        buttonType = TinyPeaceButtonType.FilledButton,
                        modifier = Modifier,
                        enable = true,
                        text = TinyPeaceButtonTextModel(
                            text = "Yes",
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Center,
                            modifier = Modifier,
                            softWrap = true,
                            maxLines = Int.MAX_VALUE,
                            minLines = 1,
                            lineHeight = TextUnit.Unspecified,
                            letterSpacing = 2.sp,
                        ),
                        basicIcon = null,
                        iconButton = null,
                        segmentedButton = null,
                        onPressInteraction = null
                    )
                ) },
                dismissButton = { TP_Button(
                    tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                        action = {
                            showAlertDialog = false
                        },
                        buttonType = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType.OutlinedButton,
                        modifier = Modifier,
                        enable = true,
                        text = TinyPeaceButtonTextModel(
                            text = "No",
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Center,
                            modifier = Modifier,
                            softWrap = true,
                            maxLines = Int.MAX_VALUE,
                            minLines = 1,
                            lineHeight = TextUnit.Unspecified,
                            letterSpacing = 2.sp,
                        ),
                        basicIcon = null,
                        iconButton = null,
                        segmentedButton = null,
                        onPressInteraction = null
                    )
                ) },
                icon = { Icon(imageVector = Icons.Default.Face, contentDescription = "") },
                title = { Text(text="Dialog Title", style = MaterialTheme.typography.bodyLarge) },
                text = { Text(text="Dialog text for some type of content you want to pop up.", style = MaterialTheme.typography.bodyLarge) }) {
                showAlertDialog = false
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogViewsPreview() {
    DialogViews()
}