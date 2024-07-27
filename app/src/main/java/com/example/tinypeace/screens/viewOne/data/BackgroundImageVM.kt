package com.example.tinypeace.screens.viewOne.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AcUnit
import androidx.compose.material.icons.outlined.BeachAccess
import androidx.compose.material.icons.outlined.Diamond
import androidx.compose.material.icons.outlined.DirectionsBoat
import androidx.compose.material.icons.outlined.DirectionsCar
import androidx.compose.material.icons.outlined.FlightLand
import androidx.compose.material.icons.outlined.FlightTakeoff
import androidx.compose.material.icons.outlined.LocationCity
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.RealEstateAgent
import androidx.compose.material.icons.outlined.Sailing
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.Spa
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

enum class ViewOneViewType {
    MainView,
    MenuView
}

class BackgroundImageVM : ViewModel() {

    private val _brandsList = MutableStateFlow(fashionList)
    val brandsList: StateFlow<List<Pair<String, Int>>> get() = _brandsList

    private val _mainMenuList = MutableStateFlow(menuList)
    val mainMenuList: StateFlow<List<Pair<String, ImageVector>>> get() = _mainMenuList

    private val _showingDrawerSheet = MutableStateFlow(true)
    val showingDrawerSheet: StateFlow<Boolean> = _showingDrawerSheet

    private val _showingSubMenusList = MutableStateFlow(Pair(false, ""))
    val showingSubMenusList: StateFlow<Pair<Boolean, String>> = _showingSubMenusList

    fun showSubMenuList(showList: Boolean, listTitle: String) {
        val newSubMenuList = Pair(showList, listTitle)
        _showingSubMenusList.value = newSubMenuList
    }

    fun showDrawSheet() {
        _showingDrawerSheet.value = !showingDrawerSheet.value
    }

    fun <T> selectBrand(type: ViewOneViewType, selectedBrand: T) {
        when (type) {
            ViewOneViewType.MainView -> {
                _brandsList.value = _brandsList.value
                    .filter { it != selectedBrand }
                    .toMutableList()
                    .apply { add(0, selectedBrand as Pair<String, Int>) }
            }
            ViewOneViewType.MenuView -> {
                _mainMenuList.value = _mainMenuList.value
                    .filter { it != selectedBrand }
                    .toMutableList()
                    .apply { add(0, selectedBrand as Pair<String, ImageVector>) }
            }
        }
    }

    fun changeBrandList(iconName: String) {
        when (iconName) {
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