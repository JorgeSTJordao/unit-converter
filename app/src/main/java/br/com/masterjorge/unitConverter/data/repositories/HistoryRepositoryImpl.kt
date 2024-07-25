package br.com.masterjorge.unitConverter.data.repositories

import br.com.masterjorge.unitConverter.data.remote.interfaces.HistoryDao
import br.com.masterjorge.unitConverter.data.remote.models.History
import br.com.masterjorge.unitConverter.domain.repositories.HistoryRepository
import kotlinx.coroutines.flow.Flow

class HistoryRepositoryImpl(private val dao: HistoryDao): HistoryRepository {
    override suspend fun insertHistory(history: History) {
        dao.insertHistory(history)
    }

    override fun getAllHistories(limitItems: Int, beginItem: Int): Flow<List<History>> {
        return dao.getAllHistories(limitItems, beginItem)
    }

    override fun getHistory(historyId: Int): Flow<History> {
        return dao.getHistory(historyId)
    }

    override suspend fun deleteHistory(historyList: List<History>) {
        dao.deleteHistory(historyList)
    }
}