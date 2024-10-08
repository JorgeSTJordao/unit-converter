package br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases

import br.com.masterjorge.unitConverter.data.remote.models.History
import br.com.masterjorge.unitConverter.domain.repositories.HistoryRepository
import kotlinx.coroutines.flow.Flow

class GetHistory(
    private val historyRepository: HistoryRepository
) {

    suspend operator fun invoke(idHistory: Int): History? {
        return historyRepository.getHistory(idHistory)
    }
}