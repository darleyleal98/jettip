package com.darleyleal.jettip.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableFloatState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SliderBar(tipPercentage: MutableFloatState, modifier: Modifier = Modifier) {
    Text(
        text = "${tipPercentage.floatValue.toInt()}%",
        color = MaterialTheme.colorScheme.surface,
        fontSize = 20.sp,
        fontWeight = FontWeight(400),
    )
    Slider(
        value = tipPercentage.floatValue,
        onValueChange = { tipPercentage.floatValue = it },
        enabled = true,
        modifier = modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colorScheme.secondary,
            activeTrackColor = Color.Cyan,
            inactiveTickColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        valueRange = 0f..100f
    )
}