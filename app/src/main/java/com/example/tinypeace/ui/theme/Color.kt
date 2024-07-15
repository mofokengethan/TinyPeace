package com.example.tinypeace.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val color1 = Color(0xFFB2DBBF)
val color2 = Color(0xFF70C1B3)
val color3 = Color(0xFF247BA0)
val color4 = Color(0xFFF3FFBD)
val color5 = Color(0xFFDBBDC3)


val background = Color(0xFFF9F7F1)
val cardBackground = Color(0xFFF2EFFA)

// Secondary Colors
val secondary90 = Color(0xFFE8EDED)
val secondary80 = Color(0xFFC6D2D2)
val secondary70 = Color(0xFFAFC0C0)
val secondary60 = Color(0xFF8DA5A5)
val secondary50 = Color(0xFF6C8989)
val secondary40 = Color(0xFF5A7272)
val secondary30 = Color(0xFF3F5050)
val secondary20 = Color(0xFF2D3939)
val secondary10 = Color(0xFF121717)

// Tertiary Colors
val tertiary90 = Color(0xFFE6EFED)
val tertiary80 = Color(0xFFC0D8D1)
val tertiary70 = Color(0xFF9AC1B6)
val tertiary60 = Color(0xFF74AA9B)
val tertiary50 = Color(0xFF558B7D)
val tertiary40 = Color(0xFF3E655B)
val tertiary30 = Color(0xFF2F4C44)
val tertiary20 = Color(0xFF1F332D)
val tertiary10 = Color(0xFF101917)

// Primary Colors
val primary90 = Color(0xFFE3F2F2)
val primary80 = Color(0xFFB9DFDF)
val primary70 = Color(0xFF8FCCCC)
val primary60 = Color(0xFF65B8B8)
val primary50 = Color(0xFF408C8C)
val primary40 = Color(0xFF337070)
val primary30 = Color(0xFF275454)
val primary20 = Color(0xFF1A3838)
val primary10 = Color(0xFF0D1C1C)


val DarkColorScheme = darkColorScheme(
    primary = primary40,
    secondary = secondary40,
    tertiary = tertiary40
)

val LightColorScheme = lightColorScheme(
    primary = primary40 ,
    onPrimary = primary90,
    primaryContainer = primary90,
    onPrimaryContainer = primary10,
    inversePrimary = primary80,
    secondary =  secondary40,
    onSecondary = secondary90,
    secondaryContainer = secondary90,
    onSecondaryContainer = secondary10,
    tertiary = tertiary40,
    onTertiary = tertiary90,
    tertiaryContainer = tertiary90,
    onTertiaryContainer = tertiary10,
    background = background ,
    onBackground = Color.Black,
    outline = Color.Black,
    outlineVariant = Color.Black,
    scrim = Color.Black,
    surface = primary20,
    onSurface =  primary10,
    surfaceVariant = primary30,
    onSurfaceVariant = tertiary30,
    surfaceTint = tertiary30,
    inverseSurface = tertiary20,
    inverseOnSurface = tertiary90,
    surfaceBright = cardBackground ,
    surfaceContainer = cardBackground,
    surfaceContainerHigh = secondary80,
    surfaceContainerHighest = secondary80,
    surfaceContainerLow = cardBackground,
    surfaceContainerLowest = tertiary90,
    surfaceDim = tertiary70,
)
