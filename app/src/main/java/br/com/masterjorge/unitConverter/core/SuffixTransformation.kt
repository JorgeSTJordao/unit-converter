package br.com.masterjorge.unitConverter.core

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class SuffixTransformation(private val suffix: String): VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val changedText = AnnotatedString(text.text + " " + suffix)
        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int = offset

            override fun transformedToOriginal(offset: Int): Int =
                if (offset <= text.text.length) offset else text.length

        }
        //Changed Text + Offset position
        return TransformedText(changedText, offsetMapping)
    }
}