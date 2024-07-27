package com.example.tinypeace.screens.viewOne.views

import androidx.annotation.Nullable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tinypeace.TinyPeaceUI.homeScreen.dmSerifDisplay
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Button
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonTextModel
import com.example.tinypeace.screens.viewOne.MainHeaderText

@Composable
fun ViewOneCard(fashionBrand: Pair<String, Int>, viewFashionBrandButton: (Pair<String, Int>) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth(1f)
            .height(420.dp)
    ) {
        MainHeaderText(text = fashionBrand.first, color = Color.White)
        TP_Button(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {
                    viewFashionBrandButton(fashionBrand)
                },
                buttonType = TinyPeaceButtonType.FilledButton,
                modifier = Modifier,
                enable = true,
                text = TinyPeaceButtonTextModel(
                    text = "View ${fashionBrand.first}",
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
        )
    }
}