package com.example.tinypeace.screens.viewOne.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tinypeace.TinyPeaceUI.homeScreen.montserratFamily

@Composable
fun SubMenuListItemVO(title: String) {
    Text(title, style = MaterialTheme.typography.bodySmall, fontFamily = montserratFamily, modifier = Modifier.padding( start = 12.dp, top = 16.dp))
    HorizontalDivider(modifier = Modifier.padding(vertical = 6.dp))
}