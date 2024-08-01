package com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.cardData.enums.TinyPeaceCardType

@Composable
fun TP_Cards(
    modifier: Modifier,
    tinyPeaceCardType: TinyPeaceCardType,
    content: @Composable (ColumnScope.() -> Unit)
) {
    when(tinyPeaceCardType) {
        TinyPeaceCardType.Card -> {
            Card(
                modifier = modifier,
                shape = CardDefaults.shape,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                elevation = CardDefaults.cardElevation(),
                border = null,
                content = content
            )
        }
        TinyPeaceCardType.ElevatedCard -> {
            ElevatedCard(
                modifier = modifier,
                shape = CardDefaults.shape,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                elevation = CardDefaults.elevatedCardElevation(),
                content = content
            )
        }
        TinyPeaceCardType.OutlinedCard -> {
            OutlinedCard(
                modifier = modifier,
                shape = CardDefaults.shape,
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                elevation = CardDefaults.outlinedCardElevation(),
                border = CardDefaults.outlinedCardBorder(),
                content = content
            )
        }
    }
}