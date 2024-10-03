package br.com.masterjorge.unitConverter.core.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable

@Composable
fun AnimateVisibilityContent(
    calculus: @Composable () -> Unit,
    record: @Composable () -> Unit,
    isVisible: Boolean
){
    AnimatedContent(targetState = isVisible, label = "show records") { targetState ->
        if (targetState){
            calculus()
        } else {
            record()
        }
    }
}