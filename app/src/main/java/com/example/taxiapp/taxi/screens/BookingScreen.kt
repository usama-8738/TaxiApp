package com.example.taxiapp.taxi.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taxiapp.R
import com.example.taxiapp.taxi.commonUi.CommonColumnsBookings
import com.example.taxiapp.taxi.commonUi.CommonTextRowsBookings
import com.example.taxiapp.taxi.navigation.PrimaryTabs
import com.example.taxiapp.ui.theme.Custom_Green
import com.example.taxiapp.ui.theme.poppins_regular
import com.example.taxiapp.ui.theme.poppins_semi_bold
import com.example.taxiapp.ui.theme.unselected_tabs

@Composable
fun BookingScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(modifier = modifier.padding(it)) {
            PrimaryTabs()
        }
    }
}

@Composable
fun UserStatus(modifier: Modifier = Modifier, activeOnClick: () -> Unit) {
    val img = painterResource(id = R.drawable.useractive)
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            Image(
                painter = img,
                contentDescription = stringResource(id = R.string.user_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 68.dp, height = 68.dp)
                    .clickable { }
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    text = stringResource(id = R.string.jibwai),
                    fontSize = 16.sp,
                    fontFamily = poppins_semi_bold,
                    lineHeight = 10.sp
                )
                Text(
                    text = stringResource(id = R.string.carName_Hyundai),
                    fontSize = 16.sp,
                    fontFamily = poppins_regular
                )
            }
            Spacer(modifier = Modifier.width(50.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .width(60.dp)
                        .height(30.dp),
                    onClick = activeOnClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Custom_Green),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.active),
                        fontFamily = poppins_regular,
                        fontSize = 12.sp
                    )
                }
                Text(
                    text = stringResource(id = R.string.carName_Hyundai_model),
                    fontFamily = poppins_semi_bold
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            CommonTextRowsBookings(title = R.string.location, icon = R.drawable.location_ico1)
            CommonTextRowsBookings(title = R.string.time_arrival, icon = R.drawable.time_icon)
            CommonTextRowsBookings(title = R.string.charge, icon = R.drawable.wallet_icon)
        }
        Text(text = stringResource(id = R.string.date_time), color = Color.Gray, fontSize = 16.sp)
        HorizontalDivider(modifier = modifier.padding(horizontal = 25.dp), thickness = 1.dp)
        CurrentLocation()
    }
}

@Composable
fun CurrentLocation() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(end = 30.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.locate_icon),
                contentDescription = stringResource(
                    id = R.string.location
                ),
                tint = Custom_Green,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            CommonColumnsBookings(
                title = R.string.my_current_location,
                textValue = R.string.my_current_location_val,
            )
        }
        Canvas(
            modifier = Modifier
                .align(Alignment.Start)
                .width(3.dp)
                .height(40.dp)
                .padding(start = 35.dp)
        ) {
            drawLine(
                color = unselected_tabs,
                strokeWidth = 5f,
                start = Offset(x = 0f, y = 0f),
                end = Offset(0f, size.height),
                pathEffect = PathEffect.dashPathEffect(intervals = floatArrayOf(10f, 10f), 0f)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(end = 37.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.location_icon),
                contentDescription = stringResource(
                    id = R.string.location
                ),
                tint = Custom_Green,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            CommonColumnsBookings(
                title = R.string.destination,
                textValue = R.string.destination_val
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .width(265.dp)
                .height(164.dp)
                .paint(
                    painterResource(id = R.drawable.map), contentScale = ContentScale.FillBounds
                )
        ) {
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            modifier = Modifier
                .width(274.dp)
                .height(51.dp),
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Custom_Green)
        ) {
            Text(text = stringResource(id = R.string.track_driver))
        }
    }
}

@Preview
@Composable
fun PreviewComposableBookingScreen() {
    BookingScreen()
}