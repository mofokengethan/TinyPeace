package com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextObfuscationMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceInteractionModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.enums.TinyPeaceInputFieldType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceInputFieldSettings
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceInputFieldsModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceSearchInputModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TP_InputField(
    textValue: String,
    modifier: Modifier,
    basicKeyboardType: KeyboardType?,
    secureFieldObfuscationMode: TextObfuscationMode,
    tinyPeaceInputFieldType: TinyPeaceInputFieldType,
    tinyPeaceInputFieldsModel: TinyPeaceInputFieldsModel,
    tinyPeaceInputFieldSettings: TinyPeaceInputFieldSettings,
    tinyPeaceInteractionSource: TinyPeaceInteractionModel,
    colors: TextFieldColors,
    onChangeValue: (String) -> Unit,
    searchModel: TinyPeaceSearchInputModel
) {

    val interactionSource = remember { MutableInteractionSource() }
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    LaunchedEffect(interactionSource) {
        scope.launch {
            interactionSource.interactions.collect { interaction ->
                when (interaction) {
                    /** When a user touches a button, the button generates Press interaction */
                    is PressInteraction.Press -> {
                        tinyPeaceInteractionSource.onPressInteraction?.invoke()
                    }
                    /** If the user lifts their finger inside the button, it generates a Release interaction,
                     * letting the button know that the click was finished */
                    is PressInteraction.Release -> {
                        tinyPeaceInteractionSource.onPressInteraction?.invoke()
                    }
                    /**
                     * If the users drags their finger outside the button, then lifts their finger,
                     * the button generates Cancel interaction, to indicate that the press was canceled */
                    is PressInteraction.Cancel -> {
                        tinyPeaceInteractionSource.onPressInteraction?.invoke()
                    }
                }
            }
        }
    }

    when(tinyPeaceInputFieldType) {
        TinyPeaceInputFieldType.TextField ->  TextField(
            value = textValue,
            onValueChange = onChangeValue,
            modifier = modifier,
            enabled = tinyPeaceInputFieldSettings.enabled,
            readOnly = tinyPeaceInputFieldSettings.readOnly,
            textStyle = tinyPeaceInputFieldsModel.textStyle,
            label = tinyPeaceInputFieldsModel.labelsAndIcons?.label,
            placeholder = tinyPeaceInputFieldsModel.labelsAndIcons?.placeholder,
            leadingIcon = tinyPeaceInputFieldsModel.labelsAndIcons?.leadingIcon,
            trailingIcon = tinyPeaceInputFieldsModel.labelsAndIcons?.trailingIcon,
            prefix= tinyPeaceInputFieldsModel.labelsAndIcons?.prefix,
            suffix = tinyPeaceInputFieldsModel.labelsAndIcons?.suffix,
            supportingText = tinyPeaceInputFieldsModel.labelsAndIcons?.supportingText,
            isError = tinyPeaceInputFieldSettings.isError,
            visualTransformation = tinyPeaceInputFieldsModel.visualTransformation,
            keyboardOptions = KeyboardOptions(
                capitalization = tinyPeaceInputFieldsModel.keyboardOptions.capitalization,
                autoCorrect = tinyPeaceInputFieldsModel.keyboardOptions.autoCorrect,
                keyboardType = tinyPeaceInputFieldsModel.keyboardOptions.keyboardType,
                imeAction = tinyPeaceInputFieldsModel.keyboardOptions.imeAction,
                platformImeOptions = tinyPeaceInputFieldsModel.keyboardOptions.platformImeOptions
            ),
            keyboardActions = KeyboardActions(
                onDone = tinyPeaceInputFieldsModel.keyboardActions.onDone,
                onGo = tinyPeaceInputFieldsModel.keyboardActions.onGo,
                onNext = tinyPeaceInputFieldsModel.keyboardActions.onNext,
                onPrevious = tinyPeaceInputFieldsModel.keyboardActions.onPrevious,
                onSearch = tinyPeaceInputFieldsModel.keyboardActions.onSearch,
                onSend = tinyPeaceInputFieldsModel.keyboardActions.onSend
            ),
            singleLine = tinyPeaceInputFieldSettings.singleLine,
            maxLines = tinyPeaceInputFieldSettings.maxLines,
            minLines = tinyPeaceInputFieldSettings.minLines,
            interactionSource = interactionSource,
            shape = TextFieldDefaults.shape,
            colors = colors
        )
        TinyPeaceInputFieldType.OutlinedTextField -> OutlinedTextField(
            value = textValue,
            onValueChange = onChangeValue,
            modifier = modifier,
            enabled = tinyPeaceInputFieldSettings.enabled,
            readOnly = tinyPeaceInputFieldSettings.readOnly,
            textStyle = tinyPeaceInputFieldsModel.textStyle,
            label = tinyPeaceInputFieldsModel.labelsAndIcons?.label,
            placeholder = tinyPeaceInputFieldsModel.labelsAndIcons?.placeholder,
            leadingIcon = tinyPeaceInputFieldsModel.labelsAndIcons?.leadingIcon,
            trailingIcon = tinyPeaceInputFieldsModel.labelsAndIcons?.trailingIcon,
            prefix= tinyPeaceInputFieldsModel.labelsAndIcons?.prefix,
            suffix = tinyPeaceInputFieldsModel.labelsAndIcons?.suffix,
            supportingText = tinyPeaceInputFieldsModel.labelsAndIcons?.supportingText,
            isError = tinyPeaceInputFieldSettings.isError,
            visualTransformation = tinyPeaceInputFieldsModel.visualTransformation,
            keyboardOptions = KeyboardOptions(
                capitalization = tinyPeaceInputFieldsModel.keyboardOptions.capitalization,
                autoCorrect = tinyPeaceInputFieldsModel.keyboardOptions.autoCorrect,
                keyboardType = tinyPeaceInputFieldsModel.keyboardOptions.keyboardType,
                imeAction = tinyPeaceInputFieldsModel.keyboardOptions.imeAction,
                platformImeOptions = tinyPeaceInputFieldsModel.keyboardOptions.platformImeOptions
            ),
            keyboardActions = KeyboardActions(
                onDone = tinyPeaceInputFieldsModel.keyboardActions.onDone,
                onGo = tinyPeaceInputFieldsModel.keyboardActions.onGo,
                onNext = tinyPeaceInputFieldsModel.keyboardActions.onNext,
                onPrevious = tinyPeaceInputFieldsModel.keyboardActions.onPrevious,
                onSearch = tinyPeaceInputFieldsModel.keyboardActions.onSearch,
                onSend = tinyPeaceInputFieldsModel.keyboardActions.onSend
            ),
            singleLine = tinyPeaceInputFieldSettings.singleLine,
            maxLines = tinyPeaceInputFieldSettings.maxLines,
            minLines = tinyPeaceInputFieldSettings.minLines,
            interactionSource = interactionSource,
            shape = TextFieldDefaults.shape,
            colors = colors
        )
        TinyPeaceInputFieldType.BasicSecureTextField -> BasicSecureTextField(
            value = textValue,
            onValueChange = onChangeValue,
            modifier = modifier,
            onSubmit = tinyPeaceInputFieldsModel.keyboardActions.onSubmit,
            imeAction = tinyPeaceInputFieldsModel.keyboardOptions.imeAction,
            textObfuscationMode = secureFieldObfuscationMode,
            keyboardType = basicKeyboardType ?: KeyboardType.Text,
            enabled = tinyPeaceInputFieldSettings.enabled,
            inputTransformation = null,
            textStyle = tinyPeaceInputFieldsModel.textStyle,
            interactionSource = interactionSource,
            cursorBrush = SolidColor(Color. Black),
            decorator = null,
            scrollState = scrollState
        )
        TinyPeaceInputFieldType.BasicTextField -> BasicSecureTextField(
            value = textValue,
            onValueChange = onChangeValue,
            modifier = modifier,
            onSubmit = tinyPeaceInputFieldsModel.keyboardActions.onSubmit,
            imeAction = tinyPeaceInputFieldsModel.keyboardOptions.imeAction,
            textObfuscationMode = secureFieldObfuscationMode,
            keyboardType = basicKeyboardType ?: KeyboardType.Text,
            enabled = tinyPeaceInputFieldSettings.enabled,
            inputTransformation = null,
            textStyle = tinyPeaceInputFieldsModel.textStyle,
            interactionSource = interactionSource,
            cursorBrush = SolidColor(Color. Black),
            decorator = null,
            scrollState = scrollState
        )
        TinyPeaceInputFieldType.BasicTextField2 -> BasicTextField2(
            value = textValue,
            onValueChange = onChangeValue,
            modifier = modifier,
            lineLimits = TextFieldLineLimits.MultiLine(),
            enabled = tinyPeaceInputFieldSettings.enabled,
            readOnly = tinyPeaceInputFieldSettings.readOnly,
            textStyle = LocalTextStyle.current,
            cursorBrush = SolidColor(Color. Black),
            keyboardOptions = KeyboardOptions.Default,
            keyboardActions = KeyboardActions.Default,
            interactionSource = interactionSource,
            scrollState = scrollState
        )
        TinyPeaceInputFieldType.SearchBar ->  SearchBar(
            query = textValue,
            onQueryChange =  searchModel.onQueryChance,
            onSearch = onChangeValue,
            active = tinyPeaceInputFieldSettings.enabled,
            onActiveChange = searchModel.onActiveChange,
            modifier = Modifier,
            enabled = tinyPeaceInputFieldSettings.enabled,
            placeholder = tinyPeaceInputFieldsModel.labelsAndIcons?.placeholder,
            leadingIcon = tinyPeaceInputFieldsModel.labelsAndIcons?.leadingIcon,
            trailingIcon = tinyPeaceInputFieldsModel.labelsAndIcons?.trailingIcon,
            shape = SearchBarDefaults.dockedShape,
            colors = SearchBarDefaults.colors(),
            tonalElevation= SearchBarDefaults.ShadowElevation,
            shadowElevation= SearchBarDefaults.TonalElevation,
            windowInsets = SearchBarDefaults.windowInsets,
            interactionSource = interactionSource,
            content = { }
        )
    }
}