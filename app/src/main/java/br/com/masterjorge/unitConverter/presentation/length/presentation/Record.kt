package br.com.masterjorge.unitConverter.presentation.length.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.masterjorge.unitConverter.domain.models.LengthPattern
import br.com.masterjorge.unitConverter.presentation.length.LengthEvents
import br.com.masterjorge.unitConverter.presentation.length.LengthMap
import br.com.masterjorge.unitConverter.presentation.length.LengthState

@Composable
fun Record(
    stateLengthState: LengthState,
    onEvent: (LengthEvents) -> Unit,
    onClick: () -> Unit,
){

    Column {
        Row (
            modifier = Modifier
                .padding(bottom = 20.dp)
                .width(290.dp)
        ) {
            Button(
                modifier = Modifier.padding(end = 15.dp),
                onClick = { onClick() }) {
                Text(text = "Retornar")
            }
            Button(onClick = { onEvent(LengthEvents.DeleteAll) }) {
                Text(text = "Deletar")
            }
        }


        LazyColumn (
            modifier = Modifier.padding(start = 10.dp)
        ){
            items(stateLengthState.recordList) { record ->
                Text(text = record.value.toString())
                Spacer(modifier = Modifier.padding(bottom = 15.dp))
            }
        }
    }
}