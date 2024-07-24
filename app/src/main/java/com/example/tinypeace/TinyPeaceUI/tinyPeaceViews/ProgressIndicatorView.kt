package com.example.tinypeace.TinyPeaceUI.tinyPeaceViews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.ProgressIndicatorModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.ProgressIndicatorType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_ProgressIndicator

@Composable
fun ProgressIndicatorsView() {
    Column(modifier = Modifier.fillMaxSize(1f)) {
        TP_ProgressIndicator(model = ProgressIndicatorModel(
            type = ProgressIndicatorType.Linear,
            value = 0.5f,
            isActive = true,
            modifier = Modifier
                .padding(20.dp)
        )
        )
        TP_ProgressIndicator(model = ProgressIndicatorModel(
            type = ProgressIndicatorType.Circular,
            value = 20.0f,
            isActive = true,
            modifier = Modifier
                .size(120.dp)
                .padding(20.dp)
        )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressIndicatorViewPreview() {
    ProgressIndicatorsView()
}