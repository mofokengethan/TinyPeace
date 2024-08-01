package com.example.tinypeace.screens.viewOne.views

import androidx.annotation.Nullable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tinypeace.TinyPeaceUI.homeScreen.dmSerifDisplay
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Button
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Cards
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceIconButtonStyleType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceBasicIconModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceIconButtonModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.cardData.enums.TinyPeaceCardType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceViews.ExampleCardContent
import com.example.tinypeace.screens.viewOne.data.BackgroundImageVM
import com.example.tinypeace.screens.viewOne.data.ViewOneViewType
import com.example.tinypeace.screens.viewOne.data.menuList
import kotlinx.coroutines.launch

@Composable
fun ViewOneDrawerSheet(vm: BackgroundImageVM) {
    val lazyScrollState = rememberLazyListState()
    val mainMenuList by vm.mainMenuList.collectAsState()
    val showSubMenList by vm.showingSubMenusList.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start, modifier = Modifier
        .fillMaxSize()
        .padding(top = 0.dp)) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.Top
        ) {
            Text("Menu",
                fontFamily = dmSerifDisplay,
                style = MaterialTheme.typography.displayLarge,
                color = Color.Black)
            Spacer(modifier = Modifier.fillMaxWidth(0.625f))
            TP_Button(
                tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                    action = {
                        vm.closeSubMenuList()
                    },
                    buttonType = TinyPeaceButtonType.IconButton,
                    modifier = Modifier
                        .size(24.dp)
                        .shadow(
                            ambientColor = Color.White,
                            spotColor = Color.White,
                            elevation = 12.dp
                        ),
                    enable = true,
                    text = null,
                    basicIcon = TinyPeaceBasicIconModel(
                        imageVector = Icons.Default.ArrowUpward,
                        description = Icons.Default.ArrowUpward.name,
                        modifier = Modifier
                    ),
                    iconButton = TinyPeaceIconButtonModel(
                        iconButtonColorType = TinyPeaceIconButtonStyleType.FilledTonal,
                        iconButtonModifier = Modifier
                            .size(30.dp),
                    ),
                    segmentedButton = null,
                    onPressInteraction = null
                )
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            TP_Button(
                tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                    action = {
                        coroutineScope.launch { // use to not break main thread
                            vm.showDrawSheet()
                            vm.closeSubMenuList()
                        }
                    },
                    buttonType = TinyPeaceButtonType.IconButton,
                    modifier = Modifier
                        .size(24.dp)
                        .shadow(
                            ambientColor = Color.White,
                            spotColor = Color.White,
                            elevation = 12.dp
                        ),
                    enable = true,
                    text = null,
                    basicIcon = TinyPeaceBasicIconModel(
                        imageVector = Icons.Default.Close,
                        description = Icons.Default.Close.name,
                        modifier = Modifier
                    ),
                    iconButton = TinyPeaceIconButtonModel(
                        iconButtonColorType = TinyPeaceIconButtonStyleType.FilledTonal,
                        iconButtonModifier = Modifier
                            .size(30.dp),
                    ),
                    segmentedButton = null,
                    onPressInteraction = null
                )
            )
        }
        
        LazyColumn(
            modifier = Modifier.fillMaxHeight(1f),
            state = lazyScrollState
        ) {
            mainMenuList.forEach { pair ->
                item {
                    ViewOneMenuCard(
                        title = pair.first,
                        title2 = pair.second,
                        showSubMenuList = showSubMenList.first,
                        selectedTitle = showSubMenList.second
                    ) {
                        // show sublist
                        vm.showSubMenuList(!showSubMenList.first, pair.first, mainMenuList.first().first)
                        // filter title
                        vm.selectBrand(ViewOneViewType.MenuView, pair)
                        coroutineScope.launch { // use to not break main thread
                            lazyScrollState.animateScrollToItem(0) // Scroll to top of screen
                        }
                    }
                }
            }
        }
    }
}