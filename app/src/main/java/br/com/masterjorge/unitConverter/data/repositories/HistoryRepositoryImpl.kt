package br.com.masterjorge.unitConverter.data.repositories

import br.com.masterjorge.unitConverter.data.remote.interfaces.HistoryDao
import br.com.masterjorge.unitConverter.data.remote.models.History
import br.com.masterjorge.unitConverter.domain.repositories.HistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class HistoryRepositoryImpl(private val dao: HistoryDao): HistoryRepository {

    override suspend fun insertHistory(history: History) {
        dao.insertHistory(history)
    }

    override suspend fun getAllHistories(): Flow<List<History>> {
        return dao.getAllHistories()
    }

    override suspend fun getHistory(historyId: Int): History? {
        return dao.getHistory(historyId)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}