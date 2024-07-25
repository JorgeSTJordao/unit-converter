package br.com.masterjorge.unitConverter.domain.use_cases

import br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases.DeleteHistory
import br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases.GetAllHistories
import br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases.GetHistory
import br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases.InsertHistory

data class LengthUseCase(
    val checkInput: CheckInput,
    val calculateLength: CalculateLength,
    val deleteHistory: DeleteHistory,
    val getAllHistories: GetAllHistories,
    val getHistory: GetHistory,
    val insertHistory: InsertHistory,
)