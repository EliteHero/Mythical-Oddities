package com.example.mythicaloddities.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mythicaloddities.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MythicalTopBar(
    screenTitle: String,
    showNavIcon: Boolean,
    onNavigationClick: () -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF1E1A30)
        ),
        title = {
            Text(
                text = screenTitle,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        },
        navigationIcon = if (showNavIcon) {
            {
                IconButton(onClick = {onNavigationClick()}) {
                    Icon(
                        painter = painterResource(R.drawable.ic_back),
                        contentDescription = "Go back",
                        tint = Color(0xFF5A5476)
                    )
                }
            }
        } else {
            {}
        }
    )
}