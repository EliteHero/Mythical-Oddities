package com.example.mythicaloddities.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mythicaloddities.data.DataSource
import com.example.mythicaloddities.model.Creature

@Composable
fun CreatureDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    creatureId: Int?
) {
    val newCreatureList = DataSource().loadCreatures().filter { creature ->
        creatureId == creature.id
    }
    CreatureDetailContent(
        newCreatureList,
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    )
}

@Composable
fun CreatureDetailContent(
    newCreatureList: List<Creature>,
    modifier: Modifier = Modifier
) {
    val creatureSelected = newCreatureList[0]
    Column(modifier = modifier) {
        Image(
            painter = painterResource(creatureSelected.imageResourceId),
            contentDescription = stringResource(creatureSelected.stringResourceId),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(16.dp))
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Creature Name",
            fontSize = 20.sp,
            color = Color(0xFFC2A4FF),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF3D325D),
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = LocalContext.current.getString(creatureSelected.stringResourceId),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(16.dp)
            )
        }
        Text(
            text = "Creature Description",
            fontSize = 20.sp,
            color = Color(0xFFC2A4FF),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF3D325D),
                contentColor = Color.White
            )
        ) {
            Text(
                text = LocalContext.current.getString(creatureSelected.detailResourceId),
                fontSize = 13.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}