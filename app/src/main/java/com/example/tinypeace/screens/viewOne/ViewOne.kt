package com.example.tinypeace.screens.viewOne

import android.content.ClipDescription
import android.view.View
import androidx.annotation.Nullable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text2.input.TextObfuscationMode
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.AcUnit
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.AddReaction
import androidx.compose.material.icons.outlined.AreaChart
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.BeachAccess
import androidx.compose.material.icons.outlined.Chalet
import androidx.compose.material.icons.outlined.Cookie
import androidx.compose.material.icons.outlined.Diamond
import androidx.compose.material.icons.outlined.DirectionsBoat
import androidx.compose.material.icons.outlined.DirectionsBus
import androidx.compose.material.icons.outlined.DirectionsCar
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.FlightLand
import androidx.compose.material.icons.outlined.FlightTakeoff
import androidx.compose.material.icons.outlined.LocationCity
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Numbers
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.RealEstateAgent
import androidx.compose.material.icons.outlined.Sailing
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.Spa
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tinypeace.R
import com.example.tinypeace.TinyPeaceUI.homeScreen.dmSerifDisplay
import com.example.tinypeace.TinyPeaceUI.homeScreen.montserratFamily
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Button
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_InputField
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceIconButtonStyleType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceBasicIconModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonTextModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceIconButtonModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceInteractionModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.iconData.IconModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.iconData.IconViewModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.enums.TinyPeaceInputFieldType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceInputFieldLabelsAndIcons
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceInputFieldSettings
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceInputFieldsModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceKeyboardActionsModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceKeyboardOptionsModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.inputFieldData.models.TinyPeaceSearchInputModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceViews.TP_AppBar
import com.example.tinypeace.screens.viewOne.data.BackgroundImageVM
import com.example.tinypeace.screens.viewOne.data.ViewOneViewType
import com.example.tinypeace.screens.viewOne.data.airportHotelsList
import com.example.tinypeace.screens.viewOne.data.artCollectiblesList
import com.example.tinypeace.screens.viewOne.data.artCollectiblesSubMenuList
import com.example.tinypeace.screens.viewOne.data.automobilesList
import com.example.tinypeace.screens.viewOne.data.cityHotelsResortsList
import com.example.tinypeace.screens.viewOne.data.fashionList
import com.example.tinypeace.screens.viewOne.data.fashionSubMenuList
import com.example.tinypeace.screens.viewOne.data.headerIcons
import com.example.tinypeace.screens.viewOne.data.internationalAirportsList
import com.example.tinypeace.screens.viewOne.data.menuList
import com.example.tinypeace.screens.viewOne.data.realEstateList
import com.example.tinypeace.screens.viewOne.data.spaWellnessRetreatsList
import com.example.tinypeace.screens.viewOne.data.summerHotelsResortsList
import com.example.tinypeace.screens.viewOne.data.watchesJewelryList
import com.example.tinypeace.screens.viewOne.data.winterHotelsResortsList
import com.example.tinypeace.screens.viewOne.data.yachtingBoatingList
import com.example.tinypeace.screens.viewOne.data.yachtingClubsMarianasList
import com.example.tinypeace.screens.viewOne.views.BackgroundImage
import com.example.tinypeace.screens.viewOne.views.ViewOneCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun ViewOne(vm: BackgroundImageVM = viewModel()) {
    // Collecting the state flow from the view model
    val fashionBrandsList by vm.brandsList.collectAsState()
    val menuList by vm.mainMenuList.collectAsState()
    val showSubMenList by vm.showingSubMenusList.collectAsState()
    val showingDrawerSheet by vm.showingDrawerSheet.collectAsState()
    val scrollState = rememberScrollState()
    val lazyScrollState = rememberLazyListState()
    val scrollState2 = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier
        .fillMaxSize(1f)
        .padding(12.dp)
        .background(Color.White)
    ) {
        // Brand Cards
        Column(
            modifier = Modifier
                .padding(4.dp)
                .verticalScroll(scrollState)
                .fillMaxSize()
        ) {
            fashionBrandsList.forEach { fashionBrand: Pair<String, Int> ->
                Box {
                    BackgroundImage(drawableId = fashionBrand.second)
                    ViewOneCard(fashionBrand = fashionBrand) { selectedFashionBrand: Pair<String, Int> ->
                        vm.selectBrand(type = ViewOneViewType.MainView, selectedFashionBrand)
                        coroutineScope.launch { // use to not break main thread
                            scrollState.animateScrollTo(0, // Scroll to top of screen
                                animationSpec = tween(durationMillis = 3000) // Adjust duration here
                            )
                        }
                    }
                }
            }
        }

        // Header Icons
        if (!showingDrawerSheet) {
            Row(modifier = Modifier.horizontalScroll(scrollState2)) {
                headerIcons.forEach { icon ->
                    TP_Button(
                        tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                            action = {
                                if (icon == Icons.Outlined.Menu) {
                                    vm.showDrawSheet()
                                    return@TinyPeaceButtonModel
                                }
                                vm.changeBrandList(icon.name)
                            },
                            buttonType = TinyPeaceButtonType.IconButton,
                            modifier = Modifier
                                .shadow(ambientColor = Color.White, spotColor = Color.White, elevation = 12.dp),
                            enable = true,
                            text = null,
                            basicIcon = TinyPeaceBasicIconModel(
                                imageVector = icon,
                                description = icon.name,
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
                }
            }
        }

        // Side Menu
        if (showingDrawerSheet) {
            ModalDrawerSheet(
                modifier = Modifier
                    .fillMaxWidth(1f),
                drawerContainerColor = Color.White
            ) {
                Box(
                    modifier = Modifier.padding(start = 10.dp)
                ) {

                    Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start, modifier = Modifier.padding(top = 0.dp)) {
                        Row(
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MainHeaderText("Menu", Color.Black)
                            Spacer(modifier = Modifier.fillMaxWidth(0.75f))
                            TP_Button(
                                tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                                    action = {
                                        vm.showDrawSheet()
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
                            modifier = Modifier.fillMaxHeight(0.9f),
                            state = lazyScrollState
                        ) {
                            menuList.forEach { pair: Pair<String, ImageVector> ->
                                item {
                                    ViewOneMenuCard(
                                        title = pair.first,
                                        icon = pair.second,
                                        showSubMenuList = showSubMenList.first,
                                        selectedTitle = showSubMenList.second
                                    ) {
                                        // filter title
                                        vm.selectBrand(ViewOneViewType.MenuView, pair)
                                        coroutineScope.launch { // use to not break main thread
                                            lazyScrollState.animateScrollToItem(0) // Scroll to top of screen
                                        }
                                        // show sublist
                                        vm.showSubMenuList(!showSubMenList.first, pair.first)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ViewOneMenuCard(
    title: String,
    icon: ImageVector,
    showSubMenuList: Boolean,
    selectedTitle: String,
    action: ()-> Unit
) {
    Row(
        modifier = Modifier
            .clickable(onClick = action)
            .fillMaxWidth(1f)
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            modifier = Modifier.padding(end = 8.dp),
            imageVector = icon,
            contentDescription = icon.name,
        )
        Text(title, fontFamily = montserratFamily, fontWeight = FontWeight.Light, fontSize = 15.sp)
    }
    if (showSubMenuList && selectedTitle == title) {
        when (selectedTitle) {
                "Fashion and Accessories" -> {
                    fashionSubMenuList.forEach { fashionBrandTitle: String ->
                        Text(fashionBrandTitle, style = MaterialTheme.typography.bodyMedium, fontFamily = FontFamily.Serif, modifier = Modifier.padding( start = 8.dp, top = 16.dp))
                        HorizontalDivider(modifier = Modifier.padding(vertical = 2.dp))
                    }
                    return
                }
                "Watches and Jewelry" -> {

                }
                "Automobiles" -> {
                    artCollectiblesSubMenuList.forEach { carBrand: String ->
                        Text(carBrand, style = MaterialTheme.typography.bodySmall, fontFamily = FontFamily.Serif)
                    }
                }
                "Art & Collectibles" -> {
                    if (selectedTitle != "0") return
                    artCollectiblesSubMenuList.forEach { collector: String ->
                        Text(collector, style = MaterialTheme.typography.bodySmall, fontFamily = FontFamily.Serif)
                    }
                }
                "International Airports" -> {

                }
                "Airport Hotels" -> {

                }
                "City Hotels and Resorts" -> {

                }
                "Summer Hotels and Resorts" -> {

                }
                 "Winter Hotels and Resorts" -> {

                 }
                "Yachting and Boats" -> {

                }
                "Yacht Clubs and Marianas" -> {

                }
                "Spas and Wellness" -> {

                }
                "Real Estate" -> {

                }
                "Popular Locations" -> {

                }
                else -> return
        }
    }
}

@Composable
fun MainHeaderText(
    text: String,
    color: Color
) {
    Text(text,
        fontFamily = dmSerifDisplay,
        style = MaterialTheme.typography.displayLarge,
        color = color)
}

@Composable
fun ViewOneDrawerSheet() {

}

@Preview(showBackground = true)
@Composable
fun ViewOnePreview() {
    ViewOne()
}