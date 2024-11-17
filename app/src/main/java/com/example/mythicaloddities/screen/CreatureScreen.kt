package com.example.mythicaloddities.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mythicaloddities.data.DataSource
import com.example.mythicaloddities.model.Creature
import com.example.mythicaloddities.model.Place
import com.example.mythicaloddities.navigation.Screen

@Composable
fun CreatureScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        item {
            CreatureList(
                creatureList = DataSource().loadCreatures(),
                modifier = Modifier.padding(16.dp),
                navController = navController
            )
        }
        item {
            PlaceList(
                placeList = DataSource().loadPlaces(),
                modifier = Modifier.padding(16.dp),
                navController = navController
            )
        }
    }
}

@Composable
fun CreatureList(
    creatureList: List<Creature>,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Column(modifier = modifier) {
        Text(
            text = "Popular Mythical Creatures",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyRow {
            items(
                items = creatureList,
                key = { creature -> creature.id }
            ) { creature ->
                CreatureCard(
                    creature = creature,
                    modifier = Modifier.padding(8.dp)
                ) {
                    navController.navigate(Screen.CreatureDetail.route + "/${creature.id}")
                }
            }
        }
    }
}

@Composable
fun CreatureCard(
    creature: Creature,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .clickable { onItemClicked(creature.id) },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF3D325D),
            contentColor = Color(0xFFC2A4FF)
        ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(creature.imageResourceId),
                contentDescription = stringResource(creature.stringResourceId),
                modifier = Modifier
                    .height(120.dp)
                    .width(96.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(creature.stringResourceId),
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun PlaceList(
    placeList: List<Place>,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Column(modifier = modifier) {
        Text(
            text = "Popular Mythical Places",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyColumn(modifier = Modifier.heightIn(max = 10000.dp)) {
            items(
                items = placeList,
                key = { place -> place.id }
            ) { place ->
                PlaceCard(
                    place = place,
                    modifier = Modifier.padding(8.dp)
                ) {
                    navController.navigate(Screen.PlaceDetail.route + "/${place.id}")
                }
            }
        }
    }
}

@Composable
fun PlaceCard(
    place: Place,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
    ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .heightIn(max = 92.dp)
            .clickable { onItemClicked(place.id) },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF3D325D),
            contentColor = Color(0xFFC2A4FF)
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(place.imageResourceId),
                contentDescription = stringResource(place.stringResourceId),
                modifier = Modifier
                    .height(92.dp)
                    .width(80.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = LocalContext.current.getString(place.stringResourceId),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp, start = 8.dp, bottom = 0.dp, end = 0.dp)
                )
                Text(
                    text = LocalContext.current.getString(place.descResourceId),
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 4.dp, start = 8.dp, bottom = 8.dp, end = 8.dp)
                )
            }
        }
    }
}