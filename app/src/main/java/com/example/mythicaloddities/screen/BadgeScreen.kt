package com.example.mythicaloddities.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.mythicaloddities.data.DataSource
import com.example.mythicaloddities.model.Badge

@Composable
fun BadgeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        BadgeList(
            badgeList = DataSource().loadBadges(),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun BadgeList(badgeList: List<Badge>, modifier: Modifier = Modifier) {
    var selectedBadge by remember { mutableStateOf<Badge?>(null) }

    val showDialog = selectedBadge != null

    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(
            items = badgeList,
            key = { badge -> badge.id }
        ) { badge ->
            BadgeCard(
                badge = badge,
                modifier = Modifier.padding(8.dp),
                onClick = { selectedBadge = badge }
            )
        }
    }

    if (showDialog) {
        selectedBadge?.let { badge ->
            BadgeDialog(
                onDismiss = { selectedBadge = null },
                badgeImage = badge.imageResourceId,
                badgeTitle = badge.stringResourceId,
                badgeDesc = badge.descResourceId
            )
        }
    }
}

@Composable
fun BadgeCard(
    badge: Badge,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(220.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF3D325D),
            contentColor = Color(0xFFFFDDA5)
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(badge.imageResourceId),
                contentDescription = stringResource(badge.stringResourceId),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Text(
                text = LocalContext.current.getString(badge.stringResourceId),
                modifier = Modifier.padding(top = 16.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun BadgeDialog(
    onDismiss: () -> Unit,
    @DrawableRes badgeImage: Int,
    @StringRes badgeTitle: Int,
    @StringRes badgeDesc: Int
) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF3D325D),
                contentColor = Color.White
            )
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(badgeImage),
                    contentDescription = stringResource(badgeTitle),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Text(
                    text = LocalContext.current.getString(badgeTitle),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFDDA5),
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                Text(
                    text = LocalContext.current.getString(badgeDesc),
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}