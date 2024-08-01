package com.example.tinypeace.screens.viewOne.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tinypeace.TinyPeaceUI.homeScreen.dmSerifDisplay
import com.example.tinypeace.model.enums.Activities
import com.example.tinypeace.model.enums.Airports
import com.example.tinypeace.model.enums.City
import com.example.tinypeace.model.enums.CollegeMajor
import com.example.tinypeace.model.enums.EducationLevel
import com.example.tinypeace.model.enums.Entertainment
import com.example.tinypeace.model.enums.HouseholdType
import com.example.tinypeace.model.enums.IncomeLevel
import com.example.tinypeace.model.enums.MaritalStatus
import com.example.tinypeace.model.enums.ZodiacSign


@Composable
fun SubMenuCardList(title: String) {
    when (title) {
        "Entertainment" -> {
            Entertainment.entries.forEach { it: Entertainment ->
                SubMenuListItemVO(title = it.emoji +" "+ it.description)
            }
        }
        "Activities" -> {
            Activities.entries.forEach { it: Activities ->
                SubMenuListItemVO(title = it.emoji +" "+ it.description)
            }
        }
        "Sports" -> {
            City.entries.forEach { it: City ->
                Text(it.name, fontWeight = FontWeight.Medium, fontFamily = dmSerifDisplay, modifier = Modifier.padding(top = 12.dp))
                it.teams.forEach {
                    SubMenuListItemVO(it.league.emoji + " " + it.name)
                }
            }
        }
        "Airports" -> {
            Airports.entries.forEach { it: Airports ->
                Column {
                    Text(it.code, fontWeight = FontWeight.Medium, fontFamily = dmSerifDisplay, modifier = Modifier.padding(top = 12.dp))
                    SubMenuListItemVO(title = it.airportName)
                }
            }
        }
        "College Majors" -> {
            CollegeMajor.entries.forEach { it: CollegeMajor ->
                SubMenuListItemVO(title = it.emoji + " " + it.description)
            }
        }
        "Households" -> {
            HouseholdType.entries.forEach { it: HouseholdType ->
                SubMenuListItemVO(title = it.emoji +" "+ it.description)
            }
        }
        "Relationships" -> {
            MaritalStatus.entries.forEach { it: MaritalStatus ->
                SubMenuListItemVO(title = it.emoji +" "+ it.description)
            }
        }
        "Zodiac Signs" -> {
            ZodiacSign.entries.forEach { it: ZodiacSign ->
                SubMenuListItemVO(title = it.representation)
            }
        }
        "Income Levels" -> {
            IncomeLevel.entries.forEach { it: IncomeLevel ->
                SubMenuListItemVO(title = it.emoji +" "+ it.description)
            }
        }
        "Education Levels" -> {
            EducationLevel.entries.forEach { it: EducationLevel ->
                SubMenuListItemVO(title = it.emoji +" "+ it.description)
            }
        }
        else -> Unit
    }
}
