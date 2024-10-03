package br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases

import br.com.masterjorge.unitConverter.data.remote.models.History
import br.com.masterjorge.unitConverter.domain.repositories.HistoryRepository

class DeleteAll(
    private val historyRepository: HistoryRepository
) {

    suspend operator fun invoke(){
        historyRepository.deleteAll()
    }
}