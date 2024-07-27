package com.example.tinypeace.model.enums

enum class HouseholdType(val emoji: String, val description: String) {
    SINGLE_PERSON("🏠", "Single Person Household"),
    COUPLE("🏡", "Couple Household"),
    FAMILY("🏠", "Family Household"),
    EXTENDED_FAMILY("🏡", "Extended Family Household"),
    ROOMMATES("🏘️", "Roommates Household")
}

