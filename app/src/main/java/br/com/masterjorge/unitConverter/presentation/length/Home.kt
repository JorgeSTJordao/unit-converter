package br.com.masterjorge.unitConverter.presentation.length

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
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
import br.com.masterjorge.unitConverter.domain.models.LengthPattern

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    stateLengthState: LengthState,
    onEvent: (LengthEvents) -> Unit,
    lengthMap: List<LengthPattern> = LengthMap.mapLength,
){
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
        ,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Column (
                modifier = Modifier
                    .weight(4f)
                    .padding(end = 20.dp)
                ,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 15.dp),
                    text = stateLengthState.value,
                    fontSize = 40.sp)

                Divider(thickness = 0.5.dp, color = Color.Gray)

                Text(
                    modifier = Modifier.padding(top = 15.dp),
                    text = stateLengthState.result.toString(),
                    fontSize = 40.sp)
            }
            Column (
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
                ,
            ) {
                Text(text = "Convert from", fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                Text(text = stateLengthState.unit1.name, fontSize = 40.sp)

                Text(text = "To", fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                Text(text = stateLengthState.unit2.name, fontSize = 40.sp)
            }
        }

        Row(
            modifier =  Modifier.fillMaxWidth()
        ){
            ButtonConverter(modifier = Modifier, symbol = "1", color = Color.LightGray) {
                
            }
        }
    }

    if (isSheetOpen) {

        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isSheetOpen = false
            }) {
            Row (
                Modifier.padding(start = 20.dp)
            ){
                Column (
                    modifier = Modifier.weight(1f)
                ) {
                    lengthMap.forEach {
                        Row {
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
                Column (
                    modifier = Modifier.weight(1f)
                ){
                    lengthMap.forEach {
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