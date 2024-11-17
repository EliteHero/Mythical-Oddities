@file:JvmName("ScreenKt")

package com.example.mythicaloddities.component

import androidx.compose.runtime.Composable
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mythicaloddities.R
import com.example.mythicaloddities.navigation.NavigationItem
import com.example.mythicaloddities.navigation.Screen

@Composable
fun MythicalBottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navigationItems = listOf(
        NavigationItem(
            title = "Creature",
            icon = R.drawable.ic_claw,
            screen = Screen.Creature
        ),
        NavigationItem(
            title = "Badge",
            icon = R.drawable.ic_achievement,
            screen = Screen.Badge
        ),
        NavigationItem(
            title = "About",
            icon = R.drawable.ic_info,
            screen = Screen.About
        )
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    NavigationBar(
        modifier = modifier,
        containerColor = Color(0xFF1E1A30),
    ) {
        navigationItems.map { item ->
            val isSelected = currentRoute?.hierarchy?.any {
                it.route == item.screen.route
            } == true
            NavigationBarItem(
                selected = isSelected,
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.title,
                        tint = if (isSelected) Color(0xFFC2A4FF) else Color(0xFF5A5476)
                    )
                },
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xFF1E1A30)
                )
            )
        }
    }
}
