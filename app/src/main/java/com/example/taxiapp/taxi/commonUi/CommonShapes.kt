package com.example.taxiapp.taxi.commonUi

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DrawCircle(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val radius = size.minDimension / 4
        val strokeWidth = 10f
        // Draw the solid circle
        drawCircle(
            color = Color.Green,
            radius = radius
        )

        // Draw the circle outline with a larger radius
        drawCircle(
            color = Color.Green,
            radius = size.minDimension / 3.5f,
            style = Stroke(width = strokeWidth)
        )
    }
}

@Preview
@Composable
fun DrawCirclePreview() {
    DrawCircle()
}
