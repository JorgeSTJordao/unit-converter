package br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases

import br.com.masterjorge.unitConverter.data.remote.models.History
import br.com.masterjorge.unitConverter.domain.repositories.HistoryRepository

class DeleteHistory(
    private val historyRepository: HistoryRepository
) {

    suspend operator fun invoke(listHistory: List<History>){
        historyRepository.deleteHistory(listHistory)
    }
}