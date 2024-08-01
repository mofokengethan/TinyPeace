package com.example.tinypeace.screens.viewOne.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tinypeace.TinyPeaceUI.homeScreen.montserratFamily

@Composable
fun ViewOneMenuCard(
    title: String,
    title2: String,
    showSubMenuList: Boolean,
    selectedTitle: String,
    action: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .clickable(onClick = action)
                .fillMaxWidth(1f)
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(title2, fontFamily = montserratFamily, fontWeight = FontWeight.Light, fontSize = 16.sp,
                modifier = Modifier.padding(end = 8.dp))
            Text(title, fontFamily = montserratFamily, fontWeight = FontWeight.Bold, fontSize = 15.sp)
        }
        HorizontalDivider()
    }
    if (showSubMenuList && selectedTitle == title) {
        SubMenuCardList(title)
    }
}