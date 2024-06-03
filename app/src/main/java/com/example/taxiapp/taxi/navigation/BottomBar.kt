package com.example.taxiapp.taxi.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taxiapp.taxi.screens.BookingScreen
import com.example.taxiapp.taxi.screens.ContinueToBook
import com.example.taxiapp.taxi.screens.HomeScreen
import com.example.taxiapp.taxi.screens.RideRoutes
import com.example.taxiapp.taxi.screens.SelectCar
import com.example.taxiapp.ui.theme.Custom_Green
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun BottomBar(
    navController: NavHostController,
    coroutineScope: CoroutineScope
) {
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }
    val bottomBarItem: List<NavGraph> = listOf(
        NavGraph.Home,
        NavGraph.Inbox,
        NavGraph.Wallet,
        NavGraph.Profile,
        NavGraph.Bookings
    )
    NavigationBar(
        containerColor = Color.White,
    ) {
        bottomBarItem.forEachIndexed { index, items ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    coroutineScope.launch {
                        navController.navigate(items.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White
                ),
                icon = {
                    Icon(
                        painter = painterResource(id = items.img),
                        contentDescription = stringResource(id = items.title),
                        tint = if (selectedItem == index) Custom_Green else Color.Black,
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = items.title),
                        style = TextStyle(
                            color = if (selectedItem == index) Custom_Green else Color.Black,
                        )
                    )
                }
            )
        }
    }
}

@Composable
fun NavigateToScreen(
    navController: NavHostController,
    coroutineScope: CoroutineScope
) {
    Scaffold(bottomBar = {
        BottomBar(navController, coroutineScope)
    })
    { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavGraph.Home.route,
            modifier = Modifier.padding(paddingValues)

        ) {
            composable(NavGraph.Home.route) {
                HomeScreen()
            }
            composable(NavGraph.Bookings.route) {
                BookingScreen()
            }
            composable(NavGraph.Profile.route) {
                SelectCar()
            }
            composable(NavGraph.Inbox.route) {
                RideRoutes()
            }
            composable(NavGraph.Wallet.route) {
                ContinueToBook()
            }
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    BottomBar(navController, coroutineScope)
}