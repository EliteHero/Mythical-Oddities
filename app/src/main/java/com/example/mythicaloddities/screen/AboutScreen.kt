package com.example.mythicaloddities.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mythicaloddities.R

@Composable
fun AboutScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        ProfileImage(modifier = Modifier.fillMaxWidth())
        AboutMeCard(modifier = Modifier.padding(16.dp))
        ContactMeSection(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ProfileImage(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.profilepicture),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 28.dp,
                        bottomEnd = 28.dp
                    )
                )
                .fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.profilename),
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                style = androidx.compose.ui.text.TextStyle(
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(4f, 4f),
                        blurRadius = 8f
                    )
                )
            )
            Text(
                text = stringResource(R.string.profilejob),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                style = androidx.compose.ui.text.TextStyle(
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(4f, 4f),
                        blurRadius = 8f
                    )
                )
            )
        }
    }
}

@Composable
fun AboutMeCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "About Me",
            color = Color(0xFFC2A4FF),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF3D325D),
                contentColor = Color.White
            )
        ) {
            Text(
                text = stringResource(R.string.aboutmedesc),
                color = Color.White,
                fontSize = 13.sp,
                lineHeight = 16.sp,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun ContactMeSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Contact Me:",
            color = Color(0xFF5A5476),
            fontSize = 13.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            buildAnnotatedString {
                pushStringAnnotation(tag = "URL", annotation = "bagassatrio807@gmail.com")
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF5A5476),
                        fontSize = 13.sp,
                        textDecoration = TextDecoration.Underline
                    )
                ) {
                    append("bagassatrio807@gmail.com")
                }
                pop()
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileImagePreview() {
    AboutScreen()
}