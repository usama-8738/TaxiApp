package com.example.taxiapp.taxi.commonUi

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taxiapp.R
import com.example.taxiapp.ui.theme.Custom_Green
import com.example.taxiapp.ui.theme.inter_regular

@Composable
fun CommonButton(
    @StringRes optionName: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        border = BorderStroke(width = 2.dp, color = Custom_Green),
        modifier = Modifier.padding(5.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.location_icon),
            contentDescription = stringResource(
                id = R.string.location
            ),
            tint = Custom_Green
        )
        Text(text = stringResource(id = optionName), color = Custom_Green, fontFamily = inter_regular)
    }
}

@Composable
fun CommonBox(
    @DrawableRes vectorImg: Int,
    @StringRes contentDescription: Int
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(40.dp)
    ) {
        Canvas(modifier = Modifier.size(35.dp), onDraw = {
            drawCircle(color = Custom_Green)
        })
        Image(
            painter = painterResource(id = vectorImg),
            contentDescription = stringResource(
                id = contentDescription
            )
        )

    }
}

@Composable
fun HomeTopIcons(@DrawableRes vectorImg: Int, @StringRes contentDescription: Int) {
    Box(
        modifier = Modifier
            .clip(shape = CircleShape)
            .background(color = Custom_Green)
            .size(36.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = vectorImg),
            contentDescription = stringResource(id = contentDescription),
            tint = Color.White
        )
    }
}

@Preview
@Composable
fun CommonButtonPreview() {
    CommonButton(optionName = R.string.home, onClick = {})
}