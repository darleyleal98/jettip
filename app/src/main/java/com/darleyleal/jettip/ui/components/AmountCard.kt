package com.darleyleal.jettip.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableFloatState
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darleyleal.jettip.R

@Composable
fun AmountCard(
    inputText: MutableState<TextFieldValue>,
    tipPercentage: MutableFloatState,
    amountOfPeopleToShare: MutableIntState,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor =
            MaterialTheme.colorScheme.onSurfaceVariant
        ),
        modifier = modifier
            .padding(start = 32.dp, end = 32.dp, top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = inputText.value,
                onValueChange = {
                    inputText.value = it
                },
                label = {
                    Text(
                        text = "Enter Bill",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = modifier.fillMaxWidth(),
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.AttachMoney,
                        contentDescription = stringResource(id = R.string.attach_money_icon),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp)
            )

            Text(
                text = "Split",
                color = MaterialTheme.colorScheme.surface,
                fontSize = 22.sp,
                fontWeight = FontWeight(400),
                modifier = modifier
                    .padding(top = 18.dp, start = 16.dp)
                    .align(Alignment.Start)
            )

            Row(
                modifier = modifier
                    .padding(top = 16.dp, end = 16.dp)
                    .offset(y = (-52).dp)
                    .align(Alignment.End)
            ) {
                SmallFloatingActionButtons(amountOfPeopleToShare = amountOfPeopleToShare)
            }
            TipValue(tipPercentage = tipPercentage)
            SliderBar(tipPercentage = tipPercentage)
        }
    }
}