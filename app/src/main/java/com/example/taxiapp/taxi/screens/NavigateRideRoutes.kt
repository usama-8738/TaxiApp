package com.example.taxiapp.taxi.screens

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taxiapp.R
import com.example.taxiapp.taxi.commonUi.DashedLine
import com.example.taxiapp.taxi.commonUi.HomeTopIcons
import com.example.taxiapp.taxi.commonUi.RecentSearched
import com.example.taxiapp.taxi.commonUi.SearchBox
import com.example.taxiapp.ui.theme.Custom_Green
import com.example.taxiapp.ui.theme.poppins_regular

@Composable
fun RideRoutes(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .paint(painterResource(id = R.drawable.map), contentScale = ContentScale.FillBounds)
        ) {
            Row(
                modifier = modifier
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
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .alpha(0.7f)
                    .background(color = Color.Black)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .height(550.dp)
                    .background(color = Color.White)
                    .align(Alignment.BottomCenter),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier.padding(top = 60.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.locate_icon),
                            contentDescription = stringResource(
                                id = R.string.location
                            ),
                            tint = Custom_Green,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        SearchBox(placeholder = R.string.from)
                    }
                    DashedLine(
                        modifier = Modifier
                            .align(Alignment.Start)
                            .width(3.dp)
                            .height(35.dp)
                            .padding(start = 50.dp)
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.location_ico1),
                            contentDescription = stringResource(
                                id = R.string.location
                            ),
                            tint = Custom_Green,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        SearchBox(placeholder = R.string.destination_route)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    HorizontalDivider(
                        modifier = Modifier.padding(
                            horizontal = 30.dp,
                            vertical = 10.dp
                        )
                    )
                    Row(
                        modifier = Modifier.padding(start = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.favorite),
                            contentDescription = stringResource(
                                id = R.string.favorite,
                            ),
                            tint = Custom_Green
                        )
                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = stringResource(id = R.string.saved_places),
                            fontFamily = poppins_regular,
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.width(170.dp))
                        Icon(
                            Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = stringResource(
                                id = R.string.favorite,
                            ),
                            tint = Custom_Green,
                            modifier = Modifier.size(40.dp),
                        )
                    }
                    HorizontalDivider(
                        modifier = Modifier.padding(
                            horizontal = 30.dp,
                            vertical = 10.dp
                        ),
                    )
                    Column(
                        modifier = Modifier.padding(end = 50.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        RecentSearched(
                            modifier = Modifier.padding(start = 10.dp),
                            locationName = R.string.giga_mall,
                            locationAddress = R.string.location_address
                        )
                        RecentSearched(
                            modifier = Modifier.padding(start = 10.dp),
                            locationName = R.string.giga_mall,
                            locationAddress = R.string.location_address
                        )
                        RecentSearched(
                            modifier = Modifier.padding(start = 10.dp),
                            locationName = R.string.giga_mall,
                            locationAddress = R.string.location_address
                        )
                        RecentSearched(
                            modifier = Modifier.padding(start = 10.dp),
                            locationName = R.string.giga_mall,
                            locationAddress = R.string.location_address
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewRideRoutes() {
    RideRoutes()
}