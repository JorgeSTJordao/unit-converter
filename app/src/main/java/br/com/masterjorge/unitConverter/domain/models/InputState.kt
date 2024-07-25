package br.com.masterjorge.unitConverter.domain.models

data class InputState (
    var isCorrect: Boolean = false,
    val isError: String? = null,
)