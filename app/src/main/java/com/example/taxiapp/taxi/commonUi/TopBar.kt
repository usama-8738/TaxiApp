package com.example.taxiapp.taxi.commonUi

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.taxiapp.R
import com.example.taxiapp.ui.theme.poppins_semi_bold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarTopBar() {
    CenterAlignedTopAppBar(
        modifier = Modifier.background(color = Color.White),
        title = {
            Text(
                text = stringResource(id = R.string.select_car),
                fontFamily = poppins_semi_bold,
                fontSize = 16.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = { })
            {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.back_button)
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.Black,
            navigationIconContentColor = Color.Black
        )
    )
}

@Preview
@Composable
fun PreviewCarTopBar() {
    CarTopBar()
}