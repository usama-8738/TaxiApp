package com.example.taxiapp.taxi.commonUi.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Vehicles(
    @DrawableRes val icon: Int,
    @StringRes val vehicleName: Int,
    @StringRes val availableSlots: Int,
    @StringRes val amount: Int,
)
