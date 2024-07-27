package com.example.tinypeace.TinyPeaceUI.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceViews.ButtonsView
import com.example.tinypeace.TinyPeaceUI.tinyPeaceViews.CardsView
import com.example.tinypeace.TinyPeaceUI.tinyPeaceViews.DialogViews
import com.example.tinypeace.TinyPeaceUI.tinyPeaceViews.InputFieldsView
import com.example.tinypeace.TinyPeaceUI.homeScreen.enums.ComponentViewTypes
import com.example.tinypeace.TinyPeaceUI.tinyPeaceViews.ActionsView
import com.example.tinypeace.TinyPeaceUI.tinyPeaceViews.ProgressIndicatorsView

@Composable
fun TinyPeaceComponentViews(
    viewType: ComponentViewTypes,
    navController: NavController,
    action: (com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType) -> Unit
) {
    Column(modifier = Modifier.fillMaxHeight()) {
        Text(
            text = "TinyPeace",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(24.dp)
        )

        when (viewType) {
            ComponentViewTypes.TopBars, ComponentViewTypes.BottomBars  -> { AppBarNavigationView(
                navController,
                buttonAction = { type -> action(type) }
            ) }
            ComponentViewTypes.Buttons -> { ButtonsView() }
            ComponentViewTypes.Communications -> { ActionsView() }
            ComponentViewTypes.Cards -> { CardsView() }
            ComponentViewTypes.InputFields -> { InputFieldsView() }
            ComponentViewTypes.Dialogs -> DialogViews()
            ComponentViewTypes.ProgressIndicators -> ProgressIndicatorsView()
        }
    }
}