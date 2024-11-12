package com.darleyleal.jettip.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableFloatState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TipValue(tipPercentage: MutableFloatState, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .offset(y = (-32).dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Tip",
            color = MaterialTheme.colorScheme.surface,
            fontSize = 22.sp,
            fontWeight = FontWeight(400),
            modifier = modifier
                .padding(start = 16.dp)
        )

        Text(
            text = "$${tipPercentage.floatValue.toInt()}",
            color = MaterialTheme.colorScheme.surface,
            fontSize = 22.sp,
            fontWeight = FontWeight(400),
            modifier = modifier
                .padding(end = 16.dp)
        )
    }
}