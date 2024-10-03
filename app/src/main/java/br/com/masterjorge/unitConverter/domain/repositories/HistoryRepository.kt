package br.com.masterjorge.unitConverter.domain.repositories

import br.com.masterjorge.unitConverter.data.remote.models.History
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    suspend fun insertHistory(history: History)

    suspend fun getAllHistories(): Flow<List<History>>

    suspend fun getHistory(historyId: Int): History?

    suspend fun deleteAll()
}