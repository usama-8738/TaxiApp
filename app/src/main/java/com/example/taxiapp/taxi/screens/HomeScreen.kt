package com.example.taxiapp.taxi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taxiapp.R
import com.example.taxiapp.taxi.commonUi.CommonButton
import com.example.taxiapp.taxi.commonUi.HomeTopIcons
import com.example.taxiapp.taxi.customViews.CustomSearch

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .paint(painterResource(id = R.drawable.map), contentScale = ContentScale.FillBounds)
        ) {
            Column(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(150.dp)
            ) {
                Row(
                    modifier = modifier
                        .align(Alignment.End)
                        .padding(end = 40.dp, top = 40.dp)
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    HomeTopIcons(
                        vectorImg = R.drawable.search_ico1,
                        contentDescription = R.string.search
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    HomeTopIcons(
                        vectorImg = R.drawable.notifications_on_ico,
                        contentDescription = R.string.notification
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = stringResource(
                        id = R.string.user_image
                    ),
                    contentScale = ContentScale.Fit,
                    modifier = modifier
                        .size(146.dp)
                        .clickable {
                        }
                )
                Row {
                    CommonButton(optionName = R.string.home, onClick = {})
                    CommonButton(optionName = R.string.home, onClick = {})
                    CommonButton(optionName = R.string.home, onClick = {})
                }
            }
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .align(Alignment.BottomCenter)
                    .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(color = Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                CustomSearch(modifier = Modifier.padding(top = 20.dp), openLocationOption = {})
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}