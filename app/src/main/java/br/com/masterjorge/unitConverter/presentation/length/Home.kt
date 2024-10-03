package br.com.masterjorge.unitConverter.presentation.length

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import br.com.masterjorge.unitConverter.core.components.AnimateVisibilityContent
import br.com.masterjorge.unitConverter.core.components.ButtonConverter
import br.com.masterjorge.unitConverter.core.components.ButtonIcon
import br.com.masterjorge.unitConverter.core.components.ButtonReadOnly
import br.com.masterjorge.unitConverter.domain.models.LengthPattern

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    stateLengthState: LengthState,
    onEvent: (LengthEvents) -> Unit,
    lengthMap: List<LengthPattern> = LengthMap.mapLength,
) {
    val sheetState = rememberModalBottomSheetState()
    var animation by rememberSaveable { mutableStateOf(true) }
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier
            .background(color = MaterialTheme.colorScheme.surface)
            .fillMaxSize()
            .padding(20.dp),
    ) {
        //Value -> Result -> Units
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 140.dp)
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
                Text(text = "Convert", fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                Text(text = stateLengthState.unit1.name, fontSize = 40.sp)

                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = "To", fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                Text(text = stateLengthState.unit2.name, fontSize = 40.sp)
            }
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
        ){
            AnimateVisibilityContent(
                calculus = {
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
                                    animation = !animation
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
                },
                record = {
                    Column {
                        Button(onClick = { animation = !animation }) {
                            Text(text = "Return")
                        }

                        Button(onClick = { onEvent(LengthEvents.DeleteAll) }) {
                            Text(text = "Deletar")
                        }

                            stateLengthState.recordList.forEach { record ->
                                Text(text = record.value.toString())
                            }
                        }
                },
                isVisible = animation
            )

            //Start - Del - C - =
            Column(verticalArrangement = Arrangement.spacedBy(23.dp)
            ) {
                ButtonIcon(modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(82.dp)
                    .aspectRatio(1f),
                    icon = Icons.Filled.Star,
                    onClick = { isSheetOpen = true }
                )

                ButtonReadOnly(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.error)
                        .width(82.dp)
                        .aspectRatio(1f),
                    symbol = "Del",
                    readOnly = stateLengthState.readOnlyDelete,
                    onClick = { onEvent(LengthEvents.Delete) }
                )

                ButtonConverter(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .width(82.dp)
                        .aspectRatio(1f),
                    symbol = "C",
                    onClick = { onEvent(LengthEvents.Clear) }
                )

                ButtonConverter(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .width(82.dp)
                        .aspectRatio(1f),
                    symbol = "=",
                    onClick = { onEvent(LengthEvents.Convert) }
                )
            }
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