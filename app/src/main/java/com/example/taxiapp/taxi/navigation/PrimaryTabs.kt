package com.example.taxiapp.taxi.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taxiapp.R
import com.example.taxiapp.ui.theme.Custom_Green
import com.example.taxiapp.ui.theme.poppins_regular
import com.example.taxiapp.ui.theme.poppins_semi_bold
import com.example.taxiapp.ui.theme.unselected_tabs
import kotlinx.coroutines.launch

@Composable
fun PrimaryTabs() {
    val tabs = listOf(
        PrimaryTabs.Active,
        PrimaryTabs.Complete,
        PrimaryTabs.Cancel
    )
    val pagerState = rememberPagerState(pageCount = {
        tabs.size
    })
    Scaffold(topBar = { TopBar() }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(color = Color.White)
        ) {
            Tabs(tabList = tabs, pagerState = pagerState)
            TabContent(tabList = tabs, pagerState = pagerState)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.my_bookings),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}

@Composable
fun Tabs(tabList: List<PrimaryTabs>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        containerColor = Color.Transparent,
        contentColor = Color.Black,
        indicator = { tabIndicator ->
            TabRowDefaults.PrimaryIndicator(
                modifier = Modifier.tabIndicatorOffset(tabIndicator[pagerState.currentPage]),
                color = Custom_Green,
                height = 4.dp,
                width = 100.dp
            )
        }
    ) {
        tabList.forEachIndexed { index, primaryTabs ->
            val isSelected = pagerState.currentPage == index
            Tab(text = {
                Text(
                    text = stringResource(id = primaryTabs.title),
                    fontSize = 16.sp,
                    fontFamily = if (isSelected) poppins_semi_bold else poppins_regular,
                    color = if (isSelected) Custom_Green else unselected_tabs
                )
            },
                selected = isSelected,
                onClick = {
                    scope.launch {
                        pagerState.scrollToPage(index)
                    }
                }
            )
        }
    }
}

@Composable
fun TabContent(tabList: List<PrimaryTabs>, pagerState: PagerState) {
    HorizontalPager(state = pagerState) { index ->
        tabList[index].displays.invoke()
    }
}

@Preview
@Composable
fun PrimaryTabsPreview() {
    PrimaryTabs()
}