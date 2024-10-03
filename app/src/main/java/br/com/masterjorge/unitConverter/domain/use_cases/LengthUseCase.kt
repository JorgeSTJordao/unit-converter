package br.com.masterjorge.unitConverter.domain.use_cases

import br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases.InsertHistory

data class LengthUseCase(
    val checkInput: CheckInput,
    val calculateLength: CalculateLength,
    val insertHistory: InsertHistory,
)