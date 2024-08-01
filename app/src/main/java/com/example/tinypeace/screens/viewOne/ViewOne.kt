package com.example.tinypeace.screens.viewOne

import androidx.annotation.Nullable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.CheckBoxOutlineBlank
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tinypeace.TinyPeaceUI.homeScreen.montserratFamily
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.ActionModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Action
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Button
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Cards
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TinyPeaceSmallComponentEnum
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceIconButtonStyleType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceBasicIconModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceIconButtonModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceInteractionModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.cardData.enums.TinyPeaceCardType
import com.example.tinypeace.screens.viewOne.data.BackgroundImageVM
import com.example.tinypeace.screens.viewOne.data.ViewOneViewType
import com.example.tinypeace.screens.viewOne.views.DualRowContent
import com.example.tinypeace.screens.viewOne.views.PostCardView
import com.example.tinypeace.screens.viewOne.views.ViewOneDrawerSheet
import com.example.tinypeace.ui.Theme.color2
import com.example.tinypeace.ui.Theme.color3
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewOne(vm: BackgroundImageVM = viewModel()) {
    val showingDrawerSheet by vm.showingDrawerSheet.collectAsState()
    val headerIconsList by vm.headerIconsList.collectAsState()
    val scrollState2 = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier
        .fillMaxSize(1f)
        .padding(12.dp)
        .background(Color.White)
    ) {

       Column {
           // Header
           if (!showingDrawerSheet) {
               Row(modifier = Modifier.horizontalScroll(scrollState2)) {
                   // Menu Icon - Drawer Sheet Icon
                   TP_Button(
                       tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                           action = {
                               coroutineScope.launch {
                                   vm.showDrawSheet()
                               }
                               return@TinyPeaceButtonModel
                           },
                           buttonType = TinyPeaceButtonType.IconButton,
                           modifier = Modifier
                               .shadow(ambientColor = Color.White, spotColor = Color.White, elevation = 12.dp),
                           enable = true,
                           text = null,
                           basicIcon = TinyPeaceBasicIconModel(
                               imageVector = Icons.Outlined.Menu,
                               description = Icons.Outlined.Menu.name,
                               modifier = Modifier
                                   .padding(horizontal = 12.dp)
                           ),
                           iconButton = TinyPeaceIconButtonModel(
                               iconButtonColorType = TinyPeaceIconButtonStyleType.FilledTonal,
                               iconButtonModifier = Modifier
                                   .padding(end = 20.dp),
                           ),
                           segmentedButton = null,
                           onPressInteraction = null
                       )
                   )
                   // Icon Header List
                   headerIconsList.forEach { icon ->
                       Text(
                           icon,
                           textAlign = TextAlign.Center,
                           fontSize = 16.sp,
                           modifier = Modifier
                               .padding(end = 16.dp)
                               .align(Alignment.CenterVertically)
                               .background(Color.Black, shape = CircleShape)
                               .padding(10.dp)
                               .clickable {
                                   vm.selectBrand(ViewOneViewType.MainView, icon)
                                   coroutineScope.launch { // use to not break main thread
                                       scrollState2.animateScrollTo(0) // Scroll to top of screen
                                   }
                               }
                       )
                   }
               }
           }

           LazyColumn(
               modifier = Modifier.fillMaxWidth(1f)
           ) {

               // Review Post
               item {
                   TP_Cards(
                       modifier = Modifier
                           .fillMaxWidth(1f)
                           .padding(6.dp),
                       tinyPeaceCardType = TinyPeaceCardType.OutlinedCard
                   ) {
                       PostCardView {
                           Text(
                               text= "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi.",
                               style = MaterialTheme.typography.bodyMedium,
                               fontFamily = montserratFamily,
                               modifier = Modifier.padding(top = 4.dp)
                           )
                           Row(modifier = Modifier.padding(0.dp))  {
                               IconButton(onClick = { /*TODO*/ }, 
                                   colors = IconButtonDefaults.iconButtonColors(contentColor = color2)) {
                                   Icon(imageVector = Icons.Outlined.Star, contentDescription = "",
                                       modifier = Modifier.size(22.dp))
                               }
                               IconButton(onClick = { /*TODO*/ },
                                   colors = IconButtonDefaults.iconButtonColors(contentColor = color2)) {
                                   Icon(imageVector = Icons.Outlined.StarBorder, contentDescription = "",
                                       modifier = Modifier.size(22.dp))
                               }
                               IconButton(onClick = { /*TODO*/ }) {
                                   Icon(imageVector = Icons.Outlined.StarBorder, contentDescription = "",
                                       modifier = Modifier.size(22.dp))
                               }
                               IconButton(onClick = { /*TODO*/ }) {
                                   Icon(imageVector = Icons.Outlined.StarBorder, contentDescription = "",
                                       modifier = Modifier.size(22.dp))
                               }
                               IconButton(onClick = { /*TODO*/ }) {
                                   Icon(imageVector = Icons.Outlined.StarBorder, contentDescription = "",
                                       modifier = Modifier.size(22.dp))
                               }
                           }
                       }
                   }
               }


               // Poll Post
               item {
                   TP_Cards(
                       modifier = Modifier
                           .padding(6.dp),
                       tinyPeaceCardType = TinyPeaceCardType.OutlinedCard
                   ) {
                       PostCardView {
                           DualRowContent(
                               leftSide = {
                                  Row(modifier = Modifier.padding(top = 8.dp)) {
                                      Icon(imageVector = Icons.Outlined.CheckBoxOutlineBlank, contentDescription = "",
                                          modifier = Modifier
                                              .padding(4.dp)
                                              .clickable {

                                              }
                                      )
                                      Text("Curabitur tempus tempor ultrices. Etiam in semper nunc, et pellentesque ex odio.")
                                  }
                              },
                               rightSide = {}
                           )

                           DualRowContent(
                               leftSide = {
                                   Row(modifier = Modifier.padding(top = 8.dp)) {
                                       Icon(imageVector = Icons.Outlined.CheckBoxOutlineBlank, contentDescription = "",
                                           modifier = Modifier
                                               .padding(4.dp)
                                               .clickable {

                                               }
                                       )
                                       Text("Curabitur tempus tempor ultrices. Etiam in semper nunc, et pellentesque ex odio.")
                                   }
                               },
                               rightSide = {}
                           )

                           val likes = 139
                           val dislikes = 43
                           val total = likes + dislikes
                           val likesPercentage = likes.toFloat() / total
                           val dislikesPercentage = dislikes.toFloat() / total

                           Row(
                               modifier = Modifier
                                   .padding(6.dp)
                                   .fillMaxWidth()
                                   .height(2.dp)
                           ) {
                               Box(
                                   modifier = Modifier
                                       .height(1.dp)
                                       .weight(likesPercentage)
                                       .background(Color.Green)
                               )
                               Box(
                                   modifier = Modifier
                                       .height(1.dp)
                                       .weight(dislikesPercentage)
                                       .background(Color.Red)
                               )
                           }
                       }

                   }
               }

               // Regular Post
               item {
                   TP_Cards(
                       modifier = Modifier
                           .fillMaxWidth(1f)
                           .padding(6.dp),
                       tinyPeaceCardType = TinyPeaceCardType.OutlinedCard
                   ) {
                       PostCardView {
                           Text(
                               text= "Aliquam interdum leo massa, sit amet fermentum odio viverra sit amet. Curabitur vitae lectus imperdiet ipsum vulputate fermentum. Nulla placerat leo a tincidunt accumsan. Praesent in efficitur ligula.",
                               style = MaterialTheme.typography.bodyMedium,
                               fontFamily = montserratFamily,
                               modifier = Modifier.padding(top = 4.dp)
                           )
                       }
                   }
               }

           }

       }

        BottomSheet(modifier = Modifier.align(Alignment.BottomCenter)) {
            
        }

        // Side Menu
        if (showingDrawerSheet) {
            ModalDrawerSheet(modifier = Modifier
                    .fillMaxSize(1f),
                drawerContainerColor = Color.White
            ) {
                ViewOneDrawerSheet(vm = vm)
            }
        }
    }
}

@Composable
fun BottomSheet(
    modifier: Modifier,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.25f)
            .background(Color.White)
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun ViewOnePreview() {
    ViewOne()
}