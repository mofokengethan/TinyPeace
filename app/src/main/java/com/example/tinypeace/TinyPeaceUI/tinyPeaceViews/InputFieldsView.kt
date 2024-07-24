package com.example.tinypeace.TinyPeaceUI.tinyPeaceViews

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text2.input.TextObfuscationMode
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddReaction
import androidx.compose.material.icons.outlined.AreaChart
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_InputField
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceInteractionModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.enums.TinyPeaceInputFieldType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceInputFieldLabelsAndIcons
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceInputFieldSettings
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceInputFieldsModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceKeyboardActionsModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceKeyboardOptionsModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceSearchInputModel


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun InputFieldsView() {
    var textFieldString by remember {
        mutableStateOf("Hello")
    }
    var outlinedFieldString by remember {
        mutableStateOf("Hello")
    }
    Column() {
        DropdownMenu(
            expanded = true,
            onDismissRequest = { /*TODO*/ }) {

        }

        TP_InputField(
            onChangeValue = { value ->
                textFieldString = value
            },
            textValue = textFieldString,
            modifier = Modifier
                .padding(8.dp),
            basicKeyboardType = null,
            secureFieldObfuscationMode = TextObfuscationMode.RevealLastTyped,
            tinyPeaceInputFieldType = TinyPeaceInputFieldType.TextField,
            tinyPeaceInputFieldsModel = TinyPeaceInputFieldsModel(
                textStyle = MaterialTheme.typography.bodySmall,
                labelsAndIcons = TinyPeaceInputFieldLabelsAndIcons(
                    label = { Text("Label",
                        style = MaterialTheme.typography.bodySmall
                    ) },
                    placeholder = { Text(
                        "Place Holder",
                        style = MaterialTheme.typography.bodySmall
                    ) },
                    leadingIcon = { Icon(
                        imageVector = Icons.Outlined.AddReaction,
                        contentDescription = "description",
                        modifier = Modifier
                    ) },
                    trailingIcon =  { Icon(
                        imageVector = Icons.Outlined.AreaChart,
                        contentDescription = "description",
                        modifier = Modifier
                    ) },
                    prefix = { Text("Mrs.",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    },
                    suffix =  { Text("M.D.",
                        style = MaterialTheme.typography.bodySmall
                    )
                    },
                    supportingText = {
                        Text("Supportive Text",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardActions = TinyPeaceKeyboardActionsModel(
                    null, null, null, null, null, null
                ),
                keyboardOptions = TinyPeaceKeyboardOptionsModel(
                    capitalization = KeyboardCapitalization.None, autoCorrect = false, keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.None, platformImeOptions = null
                )
            ),
            tinyPeaceInputFieldSettings = TinyPeaceInputFieldSettings(
                enabled = true, readOnly = false, isError = false, singleLine = true,
                maxLines = 1, minLines = 1
            ),
            tinyPeaceInteractionSource = TinyPeaceInteractionModel(
                null, null, null
            ),
            colors = TextFieldDefaults.colors(),
            searchModel = TinyPeaceSearchInputModel({},{})
        )


        TP_InputField(
            onChangeValue = { value ->
                outlinedFieldString = value
            },
            textValue = outlinedFieldString,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(8.dp),
            basicKeyboardType = null,
            secureFieldObfuscationMode = TextObfuscationMode.Hidden,
            tinyPeaceInputFieldType = TinyPeaceInputFieldType.OutlinedTextField,
            tinyPeaceInputFieldsModel = TinyPeaceInputFieldsModel(
                textStyle = MaterialTheme.typography.bodySmall,
                labelsAndIcons = TinyPeaceInputFieldLabelsAndIcons(
                    label = { Text("Label",
                        style = MaterialTheme.typography.bodySmall
                    ) },
                    placeholder = { Text(
                        "Place Holder",
                        style = MaterialTheme.typography.bodySmall
                    ) },
                    leadingIcon = { Icon(
                        imageVector = Icons.Outlined.AddReaction,
                        contentDescription = "description",
                        modifier = Modifier
                    ) },
                    trailingIcon =  { Icon(
                        imageVector = Icons.Outlined.AreaChart,
                        contentDescription = "description",
                        modifier = Modifier
                    ) },
                    prefix = { Text("Mrs.",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    },
                    suffix =  { Text("M.D.",
                        style = MaterialTheme.typography.bodySmall
                    )
                    },
                    supportingText = {
                        Text("Supportive Text",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                ),
                visualTransformation = VisualTransformation.None,
                keyboardActions = TinyPeaceKeyboardActionsModel(
                    null, null, null, null, null, null
                ),
                keyboardOptions = TinyPeaceKeyboardOptionsModel(
                    capitalization = KeyboardCapitalization.None, autoCorrect = false, keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.None, platformImeOptions = null
                )
            ),
            tinyPeaceInputFieldSettings = TinyPeaceInputFieldSettings(
                enabled = true, readOnly = false, isError = false, singleLine = true,
                maxLines = 1, minLines = 1
            ),
            tinyPeaceInteractionSource = TinyPeaceInteractionModel(
                null, null, null
            ),
            colors = TextFieldDefaults.colors(),
            searchModel = TinyPeaceSearchInputModel({},{})
        )
//
//
//
//        TP_InputField(
//            onChangeValue = { value ->
//                outlinedFieldString = value
//            },
//            textValue = outlinedFieldString,
//            modifier = Modifier
//                .fillMaxWidth(1f)
//                .padding(8.dp),
//            basicKeyboardType = null,
//            secureFieldObfuscationMode = TextObfuscationMode.Hidden,
//            tinyPeaceInputFieldType = TinyPeaceInputFieldType.SearchBar,
//            tinyPeaceInputFieldsModel = TinyPeaceInputFieldsModel(
//                textStyle = MaterialTheme.typography.bodySmall,
//                labelsAndIcons = TinyPeaceInputFieldLabelsAndIcons(
//                    label = { Text("Label",
//                        style = MaterialTheme.typography.bodySmall
//                    ) },
//                    placeholder = { Text(
//                        "Place Holder",
//                        style = MaterialTheme.typography.bodySmall
//                    ) },
//                    leadingIcon = { Icon(
//                        imageVector = Icons.Outlined.AddReaction,
//                        contentDescription = "description",
//                        modifier = Modifier
//                    ) },
//                    trailingIcon =  { Icon(
//                        imageVector = Icons.Outlined.AreaChart,
//                        contentDescription = "description",
//                        modifier = Modifier
//                    ) },
//                    prefix = { Text("Mrs.",
//                        style = MaterialTheme.typography.bodySmall,
//                        modifier = Modifier.padding(end = 8.dp)
//                    )
//                    },
//                    suffix =  { Text("M.D.",
//                        style = MaterialTheme.typography.bodySmall
//                    )
//                    },
//                    supportingText = {
//                        Text("Supportive Text",
//                            style = MaterialTheme.typography.bodySmall
//                        )
//                    }
//                ),
//                visualTransformation = VisualTransformation.None,
//                keyboardActions = TinyPeaceKeyboardActionsModel(
//                    null, null, null, null, null, null
//                ),
//                keyboardOptions = TinyPeaceKeyboardOptionsModel(
//                    capitalization = KeyboardCapitalization.None, autoCorrect = false, keyboardType = KeyboardType.Text,
//                    imeAction = ImeAction.None, platformImeOptions = null
//                )
//            ),
//            tinyPeaceInputFieldSettings = TinyPeaceInputFieldSettings(
//                enabled = true, readOnly = false, isError = false, singleLine = true,
//                maxLines = 1, minLines = 1
//            ),
//            tinyPeaceInteractionSource = TinyPeaceInteractionModel(
//                null, null, null
//            ),
//            colors = TextFieldDefaults.colors(),
//            searchModel = TinyPeaceSearchInputModel({},{})
//        )

        TP_InputField(
            onChangeValue = { value ->
                outlinedFieldString = value
            },
            textValue = outlinedFieldString,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(8.dp),
            basicKeyboardType = null,
            secureFieldObfuscationMode = TextObfuscationMode.Hidden,
            tinyPeaceInputFieldType = TinyPeaceInputFieldType.OutlinedTextField,
            tinyPeaceInputFieldsModel = TinyPeaceInputFieldsModel(
                textStyle = MaterialTheme.typography.bodySmall,
                labelsAndIcons = TinyPeaceInputFieldLabelsAndIcons(
                    label = { Text("Label",
                        style = MaterialTheme.typography.bodySmall
                    ) },
                    placeholder = { Text(
                        "Place Holder",
                        style = MaterialTheme.typography.bodySmall
                    ) },
                    leadingIcon = { Icon(
                        imageVector = Icons.Outlined.AddReaction,
                        contentDescription = "description",
                        modifier = Modifier
                    ) },
                    trailingIcon =  { Icon(
                        imageVector = Icons.Outlined.AreaChart,
                        contentDescription = "description",
                        modifier = Modifier
                    ) },
                    prefix = { Text("Mrs.",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    },
                    suffix =  { Text("M.D.",
                        style = MaterialTheme.typography.bodySmall
                    )
                    },
                    supportingText = {
                        Text("Supportive Text",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                ),
                visualTransformation = VisualTransformation.None,
                keyboardActions = TinyPeaceKeyboardActionsModel(
                    null, null, null, null, null, null
                ),
                keyboardOptions = TinyPeaceKeyboardOptionsModel(
                    capitalization = KeyboardCapitalization.None, autoCorrect = false, keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.None, platformImeOptions = null
                )
            ),
            tinyPeaceInputFieldSettings = TinyPeaceInputFieldSettings(
                enabled = true, readOnly = false, isError = false, singleLine = true,
                maxLines = 1, minLines = 1
            ),
            tinyPeaceInteractionSource = TinyPeaceInteractionModel(
                null, null, null
            ),
            colors = TextFieldDefaults.colors(),
            searchModel = TinyPeaceSearchInputModel({},{})
        )

    }
}

@Preview(showBackground = true)
@Composable
fun InputFieldsPreview() {
    InputFieldsView()
}