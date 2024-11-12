package com.darleyleal.jettip.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.darleyleal.jettip.ui.components.AmountCard
import com.darleyleal.jettip.ui.components.TotalBillCard

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column {
        var totalPayble by remember { mutableFloatStateOf(0f) }
        val inputText = remember { mutableStateOf(TextFieldValue("")) }
        val amountOfPeopleToShare = remember { mutableIntStateOf(0) }
        val tipPercentage = remember { mutableFloatStateOf(0f) }

        totalPayble = calculateTotalPayble(
            inputText.value.text,
            amountOfPeopleToShare.intValue,
            tipPercentage.floatValue.toInt()
        )

        TotalBillCard(totalPayble = totalPayble)

        AmountCard(
            inputText = inputText, tipPercentage = tipPercentage,
            amountOfPeopleToShare = amountOfPeopleToShare
        )
    }
}

fun calculateTotalPayble(
    inputValue: String,
    amountOfPeopleToShare: Int, tipPercentage: Int
): Float {
    var result = 0f
    var value = 0f
    if (inputValue.isNotEmpty()) {
        try {
            value = inputValue.toFloat()
            if (amountOfPeopleToShare != 0) {
                result = (value + (value * (tipPercentage.toFloat() / 100))) / amountOfPeopleToShare
            } else {
                result = value + (value * (tipPercentage.toFloat() / 100))
            }
        } catch (exception: Exception) {
            value = 0f
        }
    }
    return result
}