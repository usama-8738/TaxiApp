package com.example.taxiapp.taxi.customViews

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taxiapp.R
import com.example.taxiapp.ui.theme.CustomSearchBackGround
import com.example.taxiapp.ui.theme.Custom_Green

@Composable
fun CustomSearch(modifier: Modifier = Modifier, openLocationOption: () -> Unit) {
    var search by rememberSaveable {
        mutableStateOf("")
    }
    Surface(
        modifier = modifier
            .wrapContentSize(),
        shadowElevation = 2.dp,
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        OutlinedTextField(
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Custom_Green,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = CustomSearchBackGround
            ),
            modifier = Modifier
                .width(311.dp)
                .height(60.dp)
                .clickable {
                },
            value = search,
            onValueChange = { search = it },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_hint), style = TextStyle(
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                )
            },
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .size(30.dp)
                        .background(color = Color.Transparent),
                    painter = painterResource(id = R.drawable.location_icon),
                    contentDescription = stringResource(id = R.string.search),
                    tint = Color.Gray,
                )
            },
            shape = RoundedCornerShape(10.dp)
        )
    }
}

@Preview
@Composable
fun CustomSearchPreview() {
    CustomSearch(modifier = Modifier, openLocationOption = {})
}
