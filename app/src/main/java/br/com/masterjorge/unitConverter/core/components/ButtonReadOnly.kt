package br.com.masterjorge.unitConverter.core.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun ButtonReadOnly(
    modifier: Modifier,
    symbol: String,
    readOnly: Boolean,
    onClick: () -> Unit
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(shape = CircleShape)
            .clickable {
                if (!readOnly)
                    onClick()
            }
            .then(modifier),
    ) {
        Text(
            color = Color.White,
            fontSize = 35.sp,
            text = symbol)
    }

}