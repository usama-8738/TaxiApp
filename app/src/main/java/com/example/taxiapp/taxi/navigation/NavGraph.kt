package com.example.taxiapp.taxi.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.taxiapp.R
import com.example.taxiapp.taxi.commonUi.CancelStatus
import com.example.taxiapp.taxi.commonUi.CompleteStatus
import com.example.taxiapp.taxi.screens.UserStatus

typealias ComposableFun = @Composable () -> Unit

sealed class NavGraph(val route: String, @StringRes val title: Int, @DrawableRes val img: Int) {
    data object Home : NavGraph("Home", R.string.home, R.drawable.home_icon)
    data object Profile : NavGraph("Profile", R.string.profile, R.drawable.person_icon)
    data object Bookings : NavGraph("Bookings", R.string.bookings, R.drawable.booking_icon)
    data object Wallet : NavGraph("Wallet", R.string.wallet, R.drawable.wallet_icon)
    data object Inbox : NavGraph("Inbox", R.string.inbox, R.drawable.inbox_icon)
}

sealed class PrimaryTabs(@StringRes val title: Int, val displays: ComposableFun) {
    data object Active :
        PrimaryTabs(R.string.activeNow, { UserStatus(modifier = Modifier, activeOnClick = {}) })

    data object Complete :
        PrimaryTabs(R.string.completed, { CompleteStatus() })

    data object Cancel :
        PrimaryTabs(R.string.cancelled, { CancelStatus() })
}