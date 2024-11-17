package com.example.mythicaloddities.navigation

sealed class Screen(val route: String) {
    data object Creature : Screen(route = "creature")
    data object Badge : Screen(route = "badge")
    data object About : Screen(route = "about")
    data object CreatureDetail : Screen(route = "creatureDetail")
    data object PlaceDetail : Screen(route = "placeDetail")
}