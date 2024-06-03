package com.example.taxiapp.taxi.commonUi

import android.content.Context
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taxiapp.R
import com.example.taxiapp.ui.theme.CustomSearchBackGround
import com.example.taxiapp.ui.theme.Custom_Gray
import com.example.taxiapp.ui.theme.Custom_Green
import com.example.taxiapp.ui.theme.location_address
import com.example.taxiapp.ui.theme.poppins_regular
import com.example.taxiapp.ui.theme.poppins_semi_bold
import com.example.taxiapp.ui.theme.unselected_tabs

@Composable
fun CommonTextRowsBookings(
    @StringRes title: Int,
    @DrawableRes icon: Int,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = stringResource(id = title),
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(id = title),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
}

@Composable
fun CommonColumnsBookings(@StringRes title: Int, @StringRes textValue: Int) {
    Column {
        Text(
            text = stringResource(id = title),
            fontFamily = poppins_semi_bold,
            color = Color.Black,
            fontSize = 15.sp,
        )
        Text(
            text = stringResource(id = textValue),
            color = Color.Gray,
            fontFamily = poppins_regular,
            fontSize = 12.sp
        )
    }
}

@Composable
fun VerticalDashedLine(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    lineLength: Float = 10f,
    gapLength: Float = 10f,
    lineThickness: Float = 5f,
    heightFraction: Float = 1f
) {
    Canvas(modifier = modifier) {
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(lineLength, gapLength), 0f)
        drawLine(
            color = color,
            start = Offset(x = size.width / 2, y = 0f),
            end = Offset(x = size.width / 2, y = size.height * heightFraction),
            strokeWidth = lineThickness,
            pathEffect = pathEffect
        )
    }
}

@Composable
fun CarCard(
    @DrawableRes icon: Int,
    @StringRes vehicleName: Int,
    @StringRes availableSlots: Int,
    @StringRes amount: Int,
    context: Context,
    selectedCard: Int,
    onSelected: () -> Unit,
) {
    Card(
        modifier = Modifier
            .width(330.dp)
            .height(83.dp),
        shape = RoundedCornerShape(19.dp),
        elevation = CardDefaults.elevatedCardElevation(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(62.dp)
                    .clip(shape = CircleShape)
                    .border(2.dp, color = Custom_Green, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = stringResource(id = vehicleName),
                    modifier = Modifier
                        .size(50.dp)
                        .background(color = Color.Transparent)
                )
            }
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = stringResource(id = vehicleName),
                    fontFamily = poppins_semi_bold,
                    fontSize = 16.sp
                )
                Text(
                    text = stringResource(id = availableSlots),
                    fontFamily = poppins_regular,
                    fontSize = 11.sp
                )
            }
            Row(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .selectable(
                        selected = selectedCard == vehicleName,
                        onClick = {
                            onSelected()
                            Toast
                                .makeText(
                                    context,
                                    context.getString(vehicleName),
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f)) // to align item to the end
                Text(
                    text = stringResource(id = amount),
                    fontFamily = poppins_regular,
                    fontSize = 16.sp
                )

                RadioButton(
                    modifier = Modifier.size(25.dp),// changing padding space between radio button and content
                    selected = selectedCard == vehicleName,
                    onClick = {
                        onSelected()
                        Toast.makeText(context, context.getString(vehicleName), Toast.LENGTH_SHORT)
                            .show()
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Custom_Green,
                        unselectedColor = Custom_Green
                    ),
                    enabled = true
                )

            }
        }
    }
}


@Preview
@Composable
fun PreviewCarCard() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CarCard(
            icon = R.drawable.home_fill,
            vehicleName = R.string.home,
            availableSlots = R.string.activeNow,
            amount = R.string.charge,
            context,
            onSelected = {},
            selectedCard = 0,
        )
    }
}

@Composable
fun DashedLine(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {

        drawLine(
            color = unselected_tabs,
            strokeWidth = 5f,
            start = Offset(x = 0f, y = 0f),
            end = Offset(0f, size.height),
            pathEffect = PathEffect.dashPathEffect(intervals = floatArrayOf(10f, 10f), 0f)
        )
    }
}

@Composable
fun RecentSearched(
    modifier: Modifier = Modifier,
    @StringRes locationName: Int,
    @StringRes locationAddress: Int
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.time),
            contentDescription = stringResource(id = R.string.time),
            tint = Custom_Gray
        )
        Column(modifier = modifier) {
            Text(
                text = stringResource(id = locationName),
                fontFamily = poppins_regular,
                fontSize = 15.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = stringResource(id = locationAddress),
                fontFamily = poppins_regular,
                fontSize = 15.sp,
                color = location_address
            )
        }
    }
}

@Composable
fun SearchBox(@StringRes placeholder: Int) {
    var searchValue by rememberSaveable {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier
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
                .width(281.dp)
                .height(50.dp)
                .clickable {
                },
            value = searchValue,
            onValueChange = { searchValue = it },
            placeholder = {
                Text(
                    text = stringResource(id = placeholder), style = TextStyle(
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                )
            },
            shape = RoundedCornerShape(10.dp)
        )
    }
}

@Preview
@Composable
fun PreviewVerticalDashedLines() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        VerticalDashedLine()
    }
}