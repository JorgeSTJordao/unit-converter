package br.com.masterjorge.unitConverter.domain.repositories

import br.com.masterjorge.unitConverter.data.remote.models.History
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    suspend fun insertHistory(history: History)

    fun getAllHistories(limitItems: Int, beginItem: Int): Flow<List<History>>

    fun getHistory(historyId: Int): Flow<History>

    suspend fun deleteHistory(historyList: List<History>)
}