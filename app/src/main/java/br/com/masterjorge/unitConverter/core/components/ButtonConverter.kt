package br.com.masterjorge.unitConverter.core.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp

@Composable
fun ButtonConverter(
    modifier: Modifier,
    symbol: String,
    canAdd: Boolean = true,
    onClick: () -> Unit,
    context: Context = LocalContext.current,
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(shape = CircleShape)
            .clickable {
                if (canAdd)
                    onClick()
                else
                    Toast.makeText(context, "Only 9 digits allowed", Toast.LENGTH_SHORT).show()
            }
            .then(modifier),
    ) {
        Text(
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 35.sp,
            text = symbol)
    }

}