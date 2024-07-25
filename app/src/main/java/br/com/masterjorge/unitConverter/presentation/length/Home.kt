package br.com.masterjorge.unitConverter.presentation.length

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.masterjorge.unitConverter.core.components.ButtonConverter
import br.com.masterjorge.unitConverter.core.components.ButtonIcon
import br.com.masterjorge.unitConverter.domain.models.LengthPattern

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    stateLengthState: LengthState,
    onEvent: (LengthEvents) -> Unit,
    lengthMap: List<LengthPattern> = LengthMap.mapLength,
) {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {
        //Value -> Result -> Units
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 25.dp)
            ) {
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(top = 10.dp, end = 20.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 5.dp),
                    text = stateLengthState.value,
                    fontSize = 40.sp,
                    maxLines = 1,
                )

                Divider(thickness = 0.5.dp, color = Color.Gray)

                Text(
                    modifier = Modifier.padding(top = 15.dp),
                    text = stateLengthState.result.toString(),
                    fontSize = 40.sp,
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Convert from", fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                Text(text = stateLengthState.unit1.name, fontSize = 40.sp)

                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = "To", fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                Text(text = stateLengthState.unit2.name, fontSize = 40.sp)
            }
        }

        //1 - 3 + Star
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 25.dp)
            ,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
            ,
        ) {
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = "1",
                onClick = { onEvent(LengthEvents.ChangeValue("1")) }
            )
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = "2",
                onClick = { onEvent(LengthEvents.ChangeValue("2")) }
            )
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = "3",
                onClick = { onEvent(LengthEvents.ChangeValue("3")) }
            )
            ButtonIcon(modifier = Modifier
                .background(Color.Green)
                .aspectRatio(1f)
                .weight(1f),
                icon = Icons.Filled.Star,
                onClick = { isSheetOpen = true }
            )
        }
        //4 - 6 + Del
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 25.dp)
            ,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = "4",
                onClick = { onEvent(LengthEvents.ChangeValue("4")) }
            )
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = "5",
                onClick = { onEvent(LengthEvents.ChangeValue("5")) }
            )
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = "6",
                onClick = { onEvent(LengthEvents.ChangeValue("6")) }
            )
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = "Del",
                onClick = { onEvent(LengthEvents.Delete) }
            )
        }
        //7 - 9 - "C"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 25.dp)
            ,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = "7",
                onClick = { onEvent(LengthEvents.ChangeValue("7")) }
            )
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = "8",
                onClick = { onEvent(LengthEvents.ChangeValue("8")) }
            )
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = "9",
                onClick = { onEvent(LengthEvents.ChangeValue("9")) }
            )
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = "C",
                onClick = { onEvent(LengthEvents.Clear) }
            )
        }
        //0 - "." - Historic - Result
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 25.dp)
            ,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = "0",
                onClick = { onEvent(LengthEvents.ChangeValue("7")) }
            )
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = ".",
                decimalReadOnly = stateLengthState.decimalReadOnly,
                onClick = { onEvent(LengthEvents.Decimal) }
            )
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = "AC",
                onClick = { onEvent(LengthEvents.Clear) }
            )
            ButtonConverter(
                modifier = Modifier
                    .background(Color.Green)
                    .aspectRatio(1f)
                    .weight(1f),
                symbol = "=",
                onClick = { onEvent(LengthEvents.Convert) }
            )
        }
    }

    if (isSheetOpen) {

        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isSheetOpen = false
            }) {
            Row(
                Modifier.padding(start = 20.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    lengthMap.forEach {
                        Row (
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (it == stateLengthState.unit1),
                                onClick = {
                                    onEvent(LengthEvents.ChangeUnit1(it))
                                }
                            )
                            Text(text = it.name)
                        }
                    }
                }
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    lengthMap.forEach {
                        Row (
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (it == stateLengthState.unit2),
                                onClick = {
                                    onEvent(LengthEvents.ChangeUnit2(it))
                                }
                            )
                            Text(text = it.name)
                        }
                    }
                }
            }
        }
    }
}