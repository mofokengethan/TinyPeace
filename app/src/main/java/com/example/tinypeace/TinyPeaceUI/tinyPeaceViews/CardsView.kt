package com.example.tinypeace.TinyPeaceUI.tinyPeaceViews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
 import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Cards
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.cardData.enums.TinyPeaceCardType


@Composable
fun CardsView() {
    Column {
        TP_Cards(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(16.dp),
            tinyPeaceCardType = TinyPeaceCardType.Card
        ) {
            ExampleCardContent(
                title = "Card Type",
                subtitle = "Regular"
            )
        }
        TP_Cards(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(16.dp),
            tinyPeaceCardType = TinyPeaceCardType.OutlinedCard
        ) {
            ExampleCardContent(
                title = "Card Type",
                subtitle = "Outlined"
            )
        }
        TP_Cards(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(16.dp),
            tinyPeaceCardType = TinyPeaceCardType.ElevatedCard
        ) {
            ExampleCardContent(
                title = "Card Type",
                subtitle = "Elevated"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ContainersViewPreview() {
    CardsView()
}