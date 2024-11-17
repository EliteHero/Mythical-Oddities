package com.example.mythicaloddities.navigation

import androidx.annotation.DrawableRes

data class NavigationItem(
    val title: String,
    @DrawableRes val icon: Int,
    val screen: Screen
)
