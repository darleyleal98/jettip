package com.darleyleal.jettip.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darleyleal.jettip.R

@Composable
fun SmallFloatingActionButtons(
    amountOfPeopleToShare: MutableIntState,
    modifier: Modifier = Modifier
) {
    SmallFloatingActionButton(
        onClick = {
            if (amountOfPeopleToShare.intValue > 0) {
                amountOfPeopleToShare.intValue--
            }
        }
    ) {
        Icon(
            imageVector = Icons.Default.Remove,
            contentDescription = stringResource(R.string.minus_icon),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }

    Spacer(modifier = modifier.padding(all = 8.dp))

    Text(
        text = amountOfPeopleToShare.intValue.toString(),
        color = MaterialTheme.colorScheme.surface,
        fontSize = 22.sp,
        fontWeight = FontWeight(400),
        modifier = modifier.padding(top = 16.dp)
    )

    Spacer(modifier = modifier.padding(all = 8.dp))

    SmallFloatingActionButton(
        onClick = { amountOfPeopleToShare.intValue++ }
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(R.string.add_icon),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}