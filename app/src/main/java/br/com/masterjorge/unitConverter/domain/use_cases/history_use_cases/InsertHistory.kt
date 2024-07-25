package br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases

import br.com.masterjorge.unitConverter.data.remote.models.History
import br.com.masterjorge.unitConverter.domain.repositories.HistoryRepository
import kotlinx.coroutines.flow.Flow

class InsertHistory(
    private val historyRepository: HistoryRepository
) {

    suspend operator fun invoke(history: History){
        historyRepository.insertHistory(history)
    }
}