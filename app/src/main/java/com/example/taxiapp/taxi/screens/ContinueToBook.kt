package com.example.taxiapp.taxi.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.taxiapp.taxi.commonUi.HomeTopIcons
import com.example.taxiapp.ui.theme.Custom_Green
import com.example.taxiapp.ui.theme.poppins_regular
import com.example.taxiapp.ui.theme.poppins_semi_bold
import com.example.taxiapp.ui.theme.unselected_tabs

@Composable
fun ContinueToBook() {
    val painter = painterResource(id = R.drawable.map1)
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(471.dp),
                painter = painter, contentDescription = stringResource(id = R.string.map),
                contentScale = ContentScale.FillBounds
            )
            Row(
                modifier = Modifier
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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .clip(shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .background(color = Color.White)
                    .align(Alignment.BottomCenter),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp, start = 30.dp, end = 30.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.distance),
                            fontFamily = poppins_semi_bold,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = stringResource(id = R.string.inKM),
                            fontFamily = poppins_regular,
                            fontSize = 20.sp
                        )
                    }
                    HorizontalDivider(
                        modifier = Modifier.padding(
                            horizontal = 30.dp,
                            vertical = 20.dp
                        )
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 100.dp)
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
                            .padding(start = 60.dp)
                    ) {
                        drawLine(
                            color = unselected_tabs,
                            strokeWidth = 5f,
                            start = Offset(x = 0f, y = 0f),
                            end = Offset(0f, size.height),
                            pathEffect = PathEffect.dashPathEffect(
                                intervals = floatArrayOf(
                                    10f,
                                    10f
                                ), 0f
                            )
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 107.dp)
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
                    Spacer(modifier = Modifier.height(30.dp))
                    Button(
                        modifier = Modifier
                            .width(274.dp)
                            .height(51.dp),
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Custom_Green)
                    ) {
                        Text(text = stringResource(id = R.string.continue_to_book))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewContinueToBook() {
    ContinueToBook()
}