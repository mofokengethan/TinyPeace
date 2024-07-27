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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text2.input.TextObfuscationMode
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
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
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.RealEstateAgent
import androidx.compose.material.icons.outlined.Sailing
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.Spa
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tinypeace.R
import com.example.tinypeace.TinyPeaceUI.homeScreen.dmSerifDisplay
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
private val fashionList = listOf(
    Pair("Armani", R.drawable.backgroundarmani),
    Pair("Balenciaga", R.drawable.backgroundbalenciaga),
    Pair("Bottega", R.drawable.backgroundbottega),
    Pair("Chanel", R.drawable.backgroundchanel),
    Pair("Burberry", R.drawable.backgroundburberry),
    Pair("Dior", R.drawable.backgrounddior),
    Pair("Fendi", R.drawable.backgroundfendi),
    Pair("Givenchy", R.drawable.backgroundgivenchy),
    Pair("Gucci", R.drawable.backgroundgucci),
    Pair("Hermes", R.drawable.backgroundhermes),
    Pair("Loewe", R.drawable.backgroundloewe),
    Pair("Louis Vuitton", R.drawable.backgroundlouisvuitton),
    Pair("Prada", R.drawable.backgroundprada),
    Pair("YSL", R.drawable.backgroundysl)
)

private val watchesJewelryList = listOf(
    Pair("Bulgari", R.drawable.backgroundbvlgari),
    Pair("Cartier", R.drawable.backgroundcartier),
    Pair("Rolex", R.drawable.backgroundrolex),
    Pair("Van Cleef", R.drawable.backgroundvancleef)
)

private val automobilesList = listOf(
    Pair("Cars", 0)
)

private val artCollectiblesList = listOf(
    Pair("Art", R.drawable.backgroundysl)
)

private val internationalAirportsList = listOf(
    Pair("INt Air", R.drawable.backgroundysl)
)

private val airportHotelsList = listOf(
    Pair("Air Hotel", R.drawable.backgroundysl)
)

private val cityHotelsResortsList = listOf(
    Pair("city hotl", R.drawable.backgroundysl)
)

private val summerHotelsResortsList = listOf(
    Pair("summer htl", R.drawable.backgroundysl)
)

private val winterHotelsResortsList = listOf(
    Pair("wintr htl", R.drawable.backgroundysl)
)

private val yachtingBoatingList = listOf(
    Pair("ybt", R.drawable.backgroundysl)
)

private val yachtingClubsMarianasList = listOf(
    Pair("ybt clubmar", R.drawable.backgroundysl)
)

private val spaWellnessRetreatsList = listOf(
    Pair("spawell", R.drawable.backgroundysl)
)

private val realEstateList = listOf(
    Pair("rlest", R.drawable.backgroundysl)
)

class BackgroundImageVM : ViewModel() {

    private val _brandsList = MutableStateFlow(fashionList)
    val brandsList: StateFlow<List<Pair<String, Int>>> get() = _brandsList

    fun selectBrand(selectedBrand: Pair<String, Int>) {
        _brandsList.value = _brandsList.value
            .filter { it != selectedBrand }
            .toMutableList()
            .apply { add(0, selectedBrand) }
    }

    fun changeBrandList(searchText: String) {
        when (searchText) {
            Icons.Outlined.Menu.name -> {

            } // Side Menu

            Icons.Outlined.ShoppingBag.name -> {
                _brandsList.value = fashionList
            } // Fashion and Accessories

            Icons.Outlined.Diamond.name  -> {
                _brandsList.value = watchesJewelryList
            } // Watches and Jewelry

            Icons.Outlined.DirectionsCar.name -> {
                _brandsList.value = automobilesList
            } // Automobiles

            Icons.Outlined.Palette.name -> {
                _brandsList.value = artCollectiblesList
            } // Art & Collectibles

            Icons.Outlined.FlightTakeoff.name -> {
                _brandsList.value = internationalAirportsList
            } // International Airports

            Icons.Outlined.FlightLand.name -> {
                _brandsList.value = airportHotelsList
            } // Airport Hotels

            Icons.Outlined.LocationCity.name -> {
                _brandsList.value = cityHotelsResortsList
            } // City Hotels and Resorts

            Icons.Outlined.BeachAccess.name -> {
                _brandsList.value = summerHotelsResortsList
            } // Summer Hotels and Resorts

            Icons.Outlined.AcUnit.name -> {
                _brandsList.value = winterHotelsResortsList
            } // Winter Hotels and Resorts

            Icons.Outlined.DirectionsBoat.name -> {
                _brandsList.value = yachtingBoatingList
            } // Yachting and Boating

            Icons.Outlined.Sailing.name -> {
                _brandsList.value = yachtingClubsMarianasList
            } // Yacht Clubs and Marianas

            Icons.Outlined.Spa.name -> {
                _brandsList.value = spaWellnessRetreatsList
            } // Spas and Wellness Retreat

            Icons.Outlined.RealEstateAgent.name -> {
                _brandsList.value = realEstateList
            } // Real Estate
        }
    }
}

@Composable
fun BackgroundImage(drawableId: Int) {
    Image(
        painter = painterResource(id = drawableId),
        contentDescription = "drawableId: $drawableId",
        contentScale = ContentScale.FillBounds,
        alpha = 0.18f,
        modifier = Modifier
            .padding(8.dp)
            .border(BorderStroke(1.6.dp, Color.Black))
            .fillMaxWidth(1f)
            .height(400.dp)
            .background(color = Color.Black)
    )
}

@Composable
fun BackgroundScreen(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(8.dp)
            .background(Color.White)
    ) {
        content()
    }
}

@Composable
fun ViewOneCard(fashionBrand: Pair<String, Int>, viewFashionBrandButton: (Pair<String, Int>) -> Unit) {

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth(1f)
            .height(420.dp)
    ) {
        Text(fashionBrand.first,
            fontFamily = dmSerifDisplay,
            style = MaterialTheme.typography.displayLarge, color = Color.White)
        TP_Button(
            tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                action = {
                    viewFashionBrandButton(fashionBrand)
                },
                buttonType = TinyPeaceButtonType.FilledButton,
                modifier = Modifier,
                enable = true,
                text = TinyPeaceButtonTextModel(
                    text = "View ${fashionBrand.first}",
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier,
                    softWrap = true,
                    maxLines = Int.MAX_VALUE,
                    minLines = 1,
                    lineHeight = TextUnit.Unspecified,
                    letterSpacing = 2.sp,
                ),
                basicIcon = null,
                iconButton = null,
                segmentedButton = null,
                onPressInteraction = null
            )
        )
    }
}

@Composable
fun ViewOne(vm: BackgroundImageVM = viewModel()) {
    // Collecting the state flow from the view model
    val fashionBrandsList by vm.brandsList.collectAsState()
    val list = listOf(
        Icons.Outlined.Menu, // Fashion and Accessories
        Icons.Outlined.FlightLand, // Fashion and Accessories
        Icons.Outlined.Diamond, // Watches and Jewelry
        Icons.Outlined.DirectionsCar, // Automobiles
        Icons.Outlined.Palette, // Art & Collectibles
        Icons.Outlined.FlightTakeoff, // International Airports
        Icons.Outlined.FlightLand, // Airport Hotels
        Icons.Outlined.LocationCity, // City Hotels and Resorts
        Icons.Outlined.BeachAccess, // Summer Hotels and Resorts
        Icons.Outlined.AcUnit, // Winter Hotels and Resorts
        Icons.Outlined.DirectionsBoat, // Yachting and Boating
        Icons.Outlined.Sailing, // Yacht Clubs and Marianas
        Icons.Outlined.Spa, // Spas and Wellness
        Icons.Outlined.RealEstateAgent, // Real Estate
    )
    val scrollState = rememberScrollState()
    val scrollState2 = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    BackgroundScreen {
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
                        vm.selectBrand(selectedFashionBrand)
                        coroutineScope.launch {
                            scrollState.animateScrollTo(0,
                                animationSpec = tween(durationMillis = 3000) // Adjust duration here
                            )
                        }
                    }
                }
            }
        }
        Row(modifier = Modifier.horizontalScroll(scrollState2)) {
            list.forEach { icon ->
                TP_Button(
                    tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                        action = {
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
}
