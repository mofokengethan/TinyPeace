package com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tinypeace.TinyPeaceUI.tinyPeaceViews.ProgressIndicatorsView

enum class ProgressIndicatorType {
    Linear,
    Circular
}

class ProgressIndicatorModel(
    var type: ProgressIndicatorType,
    var value: Float,
    var isActive: Boolean,
    var modifier: Modifier
)

@Composable
fun TP_ProgressIndicator(model: ProgressIndicatorModel) {

    val currentProgress by remember { mutableFloatStateOf(model.value) }

    when (model.type) {
        ProgressIndicatorType.Linear -> {
            LinearProgressIndicator(
                progress = { currentProgress },
                modifier = model.modifier,
            )
        }
        ProgressIndicatorType.Circular -> {
            if (model.isActive) {
                CircularProgressIndicator(
                    modifier = model.modifier,
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            }
        }
    }
}

@Preview(showBackground=true)
@Composable
fun TP_ProgressIndicatorPreview() {
    ProgressIndicatorsView()
}