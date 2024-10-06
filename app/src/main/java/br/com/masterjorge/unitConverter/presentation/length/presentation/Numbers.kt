package br.com.masterjorge.unitConverter.presentation.length.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.masterjorge.unitConverter.core.components.ButtonConverter
import br.com.masterjorge.unitConverter.core.components.ButtonIcon
import br.com.masterjorge.unitConverter.core.components.ButtonReadOnly
import br.com.masterjorge.unitConverter.domain.models.LengthPattern
import br.com.masterjorge.unitConverter.presentation.length.LengthEvents
import br.com.masterjorge.unitConverter.presentation.length.LengthMap
import br.com.masterjorge.unitConverter.presentation.length.LengthState

@Composable
fun Numbers(
    stateLengthState: LengthState,
    onEvent: (LengthEvents) -> Unit,
    onClick: () -> Unit,
){

    Column (
        modifier = Modifier.padding(start = 15.dp, end = 10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        //1 - 3
        Row(
            modifier = Modifier
                .padding(bottom = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            ButtonConverter(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(80.dp)
                    .aspectRatio(1f),
                symbol = "1",
                canAdd = stateLengthState.canAdd,
                onClick = { onEvent(LengthEvents.ChangeValue("1")) }
            )

            ButtonConverter(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(80.dp)
                    .aspectRatio(1f),
                symbol = "2",
                canAdd = stateLengthState.canAdd,
                onClick = { onEvent(LengthEvents.ChangeValue("2")) }
            )

            ButtonConverter(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(80.dp)
                    .aspectRatio(1f),
                symbol = "3",
                canAdd = stateLengthState.canAdd,
                onClick = { onEvent(LengthEvents.ChangeValue("3")) }
            )
        }

        //4 - 6
        Row(
            modifier = Modifier
                .padding(bottom = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {

            ButtonConverter(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(80.dp)
                    .aspectRatio(1f),
                symbol = "4",
                canAdd = stateLengthState.canAdd,
                onClick = { onEvent(LengthEvents.ChangeValue("4")) }
            )

            ButtonConverter(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(80.dp)
                    .aspectRatio(1f),
                symbol = "5",
                canAdd = stateLengthState.canAdd,
                onClick = { onEvent(LengthEvents.ChangeValue("5")) }
            )

            ButtonConverter(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(80.dp)
                    .aspectRatio(1f),
                symbol = "6",
                canAdd = stateLengthState.canAdd,
                onClick = { onEvent(LengthEvents.ChangeValue("6")) }
            )
        }

        //7 - 9
        Row(
            modifier = Modifier
                .padding(bottom = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {

            ButtonConverter(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(80.dp)
                    .aspectRatio(1f),
                symbol = "7",
                canAdd = stateLengthState.canAdd,
                onClick = { onEvent(LengthEvents.ChangeValue("7")) }
            )

            ButtonConverter(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(80.dp)
                    .aspectRatio(1f),
                symbol = "8",
                canAdd = stateLengthState.canAdd,
                onClick = { onEvent(LengthEvents.ChangeValue("8")) }
            )

            ButtonConverter(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(80.dp)
                    .aspectRatio(1f),
                symbol = "9",
                canAdd = stateLengthState.canAdd,
                onClick = { onEvent(LengthEvents.ChangeValue("9")) }
            )
        }

        //Historic - 0 - "." - Result
        Row(
            modifier = Modifier
                .padding(bottom = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            ButtonIcon(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(80.dp)
                    .aspectRatio(1f),
                icon = Icons.Filled.List,
                onClick = {
                    onClick()
                }
            )

            ButtonConverter(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(80.dp)
                    .aspectRatio(1f),
                symbol = "0",
                canAdd = stateLengthState.canAdd,
                onClick = { onEvent(LengthEvents.ChangeValue("0")) }
            )

            ButtonReadOnly(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(80.dp)
                    .aspectRatio(1f),
                symbol = ".",
                readOnly = stateLengthState.readOnlyDecimal,
                onClick = { onEvent(LengthEvents.Decimal) }
            )

        }
    }
}