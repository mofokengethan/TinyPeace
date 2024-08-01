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



// header icons for main view
val headerIcons = listOf(
    "🎭", // Entertainment
    "🎨", // Activities
    "⚽", // Sports
    "✈️", // Airports
    "🎓", // College Majors
    "🏠", // Households
    "❤️", // Relationships
    "♈",// Zodiac Signs
    "💰", // Income Levels
    "📚" // Education Levels
)

// menu list for side menu
// - does not include menu icon

val menuList = listOf(
    Pair("Entertainment", "🎭"),
    Pair("Activities", "🎨"),
    Pair("Sports", "⚽"),
    Pair("Airports", "✈️"),
    Pair("College Majors", "🎓"),
    Pair("Households", "🏠"),
    Pair("Relationships", "❤️"),
    Pair("Zodiac Signs", "♈"),
    Pair("Income", "💰"),
    Pair("Education", "📚")
)

class BackgroundImageVM : ViewModel() {

    private val _headerIconsList = MutableStateFlow(headerIcons)
    val headerIconsList: StateFlow<List<String>> get() = _headerIconsList

    private val _mainMenuList = MutableStateFlow(menuList)
    val mainMenuList: StateFlow<List<Pair<String, String>>> get() = _mainMenuList

    private val _showingDrawerSheet = MutableStateFlow(false)
    val showingDrawerSheet: StateFlow<Boolean> = _showingDrawerSheet

    private val _showingSubMenusList = MutableStateFlow(Pair(false, ""))
    val showingSubMenusList: StateFlow<Pair<Boolean, String>> = _showingSubMenusList

    fun closeSubMenuList() {
        if (showingSubMenusList.value.first == true) {
            val newSubMenu = Pair(false, showingSubMenusList.value.second)
            _showingSubMenusList.value = newSubMenu
        }
    }

    fun showSubMenuList(showList: Boolean, listTitle: String, indexTitle: String) {
        when (showList) {
            false -> {
                if (listTitle == indexTitle) {
                    val newSubMenuList = Pair(false, listTitle)
                    _showingSubMenusList.value = newSubMenuList
                } else {
                    val newSubMenuList = Pair(true, listTitle)
                    _showingSubMenusList.value = newSubMenuList
                }
            }
            true -> {
                if (listTitle == indexTitle) {
                    val newSubMenuList = Pair(true, listTitle)
                    _showingSubMenusList.value = newSubMenuList
                } else {
                    val newSubMenuList = Pair(true, listTitle)
                    _showingSubMenusList.value = newSubMenuList
                }
            }
        }
    }

    fun showDrawSheet() {
        _showingDrawerSheet.value = !showingDrawerSheet.value
    }

    fun <T> selectBrand(type: ViewOneViewType, selectedBrand: T) {
        when (type) {
            ViewOneViewType.MainView -> {
                _headerIconsList.value = _headerIconsList.value
                    .filter { it != selectedBrand }
                    .toMutableList()
                    .apply { add(0, selectedBrand as String) }
            }
            ViewOneViewType.MenuView -> {
                _mainMenuList.value = _mainMenuList.value
                    .filter { it != selectedBrand }
                    .toMutableList()
                    .apply { add(0, selectedBrand as Pair<String, String>) }
            }
        }
    }
}