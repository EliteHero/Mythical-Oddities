package com.example.mythicaloddities

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mythicaloddities.component.MythicalBottomBar
import com.example.mythicaloddities.component.MythicalTopBar
import com.example.mythicaloddities.navigation.Screen
import com.example.mythicaloddities.screen.AboutScreen
import com.example.mythicaloddities.screen.BadgeScreen
import com.example.mythicaloddities.screen.CreatureDetailScreen
import com.example.mythicaloddities.screen.CreatureScreen
import com.example.mythicaloddities.screen.PlaceDetailScreen

@Composable
fun MythicalOddities() {
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    val context = LocalContext.current

    val screenTitle = when {
        currentRoute == "creature" -> "Mythical Oddities"
        currentRoute == "badge" -> "Mythical Achievements"
        currentRoute?.startsWith("creatureDetail") == true -> "Creature Detail"
        currentRoute?.startsWith("placeDetail") == true -> "Place Detail"
        else -> "About the App"
    }

    val showNavIcon = currentRoute?.startsWith("creatureDetail") == true || currentRoute?.startsWith("placeDetail") == true

    Scaffold(
        topBar = {MythicalTopBar(
            screenTitle,
            showNavIcon,
            onNavigationClick = {navController.popBackStack()}
        )},
        bottomBar = { MythicalBottomBar(navController = navController) },
        containerColor = Color(0xFF1E1A30)
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Creature.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Creature.route) { CreatureScreen(navController) }
            composable(Screen.Badge.route) { BadgeScreen() }
            composable(Screen.About.route) { AboutScreen() }
            composable(Screen.CreatureDetail.route + "/{creatureId}") { navBackStackEntry ->
                val creatureId = navBackStackEntry.arguments?.getString("creatureId")?.toIntOrNull()
                CreatureDetailScreen(navController = navController, creatureId = creatureId)
            }
            composable(Screen.PlaceDetail.route + "/{placeId}") { navBackStackEntry ->
                val placeId = navBackStackEntry.arguments?.getString("placeId")?.toIntOrNull()
                PlaceDetailScreen(navController = navController, placeId = placeId)
            }
        }
    }
}