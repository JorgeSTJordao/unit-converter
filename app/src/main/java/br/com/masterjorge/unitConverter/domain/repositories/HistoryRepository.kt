package br.com.masterjorge.unitConverter.domain.repositories

import br.com.masterjorge.unitConverter.data.remote.models.History
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    suspend fun insertHistory(history: History)

    suspend fun getAllHistories(limitItems: Int, offset: Int): List<History>

    fun getHistory(historyId: Int): Flow<History>

    suspend fun deleteHistory(allRecords: List<History>)
}