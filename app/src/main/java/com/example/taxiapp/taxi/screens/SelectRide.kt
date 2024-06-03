package com.example.taxiapp.taxi.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taxiapp.R
import com.example.taxiapp.taxi.commonUi.CarCard
import com.example.taxiapp.taxi.commonUi.CarTopBar
import com.example.taxiapp.taxi.commonUi.CommonTextRowsBookings
import com.example.taxiapp.taxi.commonUi.model.Vehicles
import com.example.taxiapp.ui.theme.CustomSearchBackGround
import com.example.taxiapp.ui.theme.Custom_Green
import com.example.taxiapp.ui.theme.poppins_regular
import com.example.taxiapp.ui.theme.poppins_semi_bold
import com.example.taxiapp.ui.theme.unselected_tabs

@Composable
fun SelectCar(modifier: Modifier = Modifier) {
    var searchVal by rememberSaveable {
        mutableStateOf("")
    }
    val context = LocalContext.current
    var selectedCard by rememberSaveable { mutableIntStateOf(0) }
    val vehicleList: List<Vehicles> = listOf(
        Vehicles(R.drawable.bike, R.string.bike, R.string.bike_available, R.string.bike_amount),
        Vehicles(
            R.drawable.carsedan,
            R.string.car_seden,
            R.string.seden_available,
            R.string.seden_amount
        ),
        Vehicles(
            R.drawable.carhatchback,
            R.string.hatchback,
            R.string.hetchback_available,
            R.string.hectchback_amount
        )
    )
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = { CarTopBar() }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.vehicle_category),
                fontSize = 12.sp,
                fontFamily = poppins_regular
            )
            LazyColumn(
                modifier = Modifier
                    .wrapContentSize(),
                contentPadding = PaddingValues(top = 10.dp, bottom = 10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(vehicleList) { vehicle ->
                    CarCard(
                        icon = vehicle.icon,
                        vehicleName = vehicle.vehicleName,
                        availableSlots = vehicle.availableSlots,
                        amount = vehicle.amount,
                        context = context,
                        selectedCard = selectedCard,
                    ) {
                        selectedCard = vehicle.vehicleName
                    }
                }
            }
            Text(
                text = stringResource(id = R.string.promo_code),
                fontFamily = poppins_semi_bold, fontSize = 16.sp
            )
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .width(274.dp)
                        .height(55.dp)
                        .padding(start = 10.dp),
                    value = searchVal, onValueChange = { value ->
                        searchVal = value
                    },
                    placeholder = {
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = stringResource(id = R.string.enter_promo_code),
                            fontFamily = poppins_regular,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Custom_Green,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = CustomSearchBackGround,
                        unfocusedTextColor = unselected_tabs
                    )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(color = Custom_Green)
                        .size(40.dp)
                ) {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = stringResource(
                                id = R.string.search
                            ),
                            tint = Color.White
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(40.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CommonTextRowsBookings(title = R.string.location, icon = R.drawable.location_ico1)
                CommonTextRowsBookings(title = R.string.time_arrival, icon = R.drawable.time_icon)
                CommonTextRowsBookings(title = R.string.charge, icon = R.drawable.wallet_icon)
            }
            Spacer(modifier = Modifier.width(40.dp))
            Button(
                modifier = Modifier
                    .width(274.dp)
                    .height(51.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Custom_Green)
            ) {
                Text(text = stringResource(id = R.string.continue_booking))
            }
        }
    }
}

@Preview
@Composable
fun PreviewSelectCar() {
    SelectCar()
}