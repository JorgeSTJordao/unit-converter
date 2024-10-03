package br.com.masterjorge.unitConverter.domain.use_cases

import br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases.DeleteAll
import br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases.GetAllHistories
import br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases.GetHistory

data class RecordUseCase(
    val getAllHistories: GetAllHistories,
    val getHistory: GetHistory,
    val deleteAll: DeleteAll
)
