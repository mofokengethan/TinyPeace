package com.example.tinypeace.screens.viewOne.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AcUnit
import androidx.compose.material.icons.outlined.BeachAccess
import androidx.compose.material.icons.outlined.Diamond
import androidx.compose.material.icons.outlined.DirectionsBoat
import androidx.compose.material.icons.outlined.DirectionsCar
import androidx.compose.material.icons.outlined.Flag
import androidx.compose.material.icons.outlined.FlightLand
import androidx.compose.material.icons.outlined.FlightTakeoff
import androidx.compose.material.icons.outlined.LocationCity
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.RealEstateAgent
import androidx.compose.material.icons.outlined.Sailing
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.Spa


// header icons for main view
// - includes menu icon
val headerIcons = listOf(
    Icons.Outlined.Menu, // Menu
    Icons.Outlined.ShoppingBag, // Fashion and Accessories
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
    Icons.Outlined.Flag, // Location
)

// menu list for side menu
// - does not include menu icon
val menuList = listOf(
    Pair("Fashion and Accessories", Icons.Outlined.ShoppingBag),
    Pair("Watches and Jewelry", Icons.Outlined.Diamond),
    Pair("Automobiles", Icons.Outlined.DirectionsCar),
    Pair("Art & Collectibles", Icons.Outlined.Palette),
    Pair("International Airports", Icons.Outlined.FlightTakeoff),
    Pair("Airport Hotels", Icons.Outlined.FlightLand),
    Pair("City Hotels and Resorts", Icons.Outlined.LocationCity),
    Pair("Summer Hotels and Resorts", Icons.Outlined.BeachAccess),
    Pair( "Winter Hotels and Resorts", Icons.Outlined.AcUnit),
    Pair("Yachting and Boats", Icons.Outlined.DirectionsBoat),
    Pair("Yacht Clubs and Marianas", Icons.Outlined.Sailing),
    Pair( "Spas and Wellness", Icons.Outlined.Spa),
    Pair( "Real Estate", Icons.Outlined.RealEstateAgent),
    Pair( "Popular Locations", Icons.Outlined.Flag)
)