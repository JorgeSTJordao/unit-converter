package br.com.masterjorge.unitConverter.data.remote.interfaces

import android.content.ClipData.Item
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.masterjorge.unitConverter.data.remote.models.History
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Insert
    suspend fun insertHistory(history: History)

    @Query("SELECT * FROM History LIMIT :limitItems OFFSET :beginItem")
    fun getAllHistories(limitItems: Int, beginItem: Int): Flow<List<History>>

    @Query("SELECT * FROM History WHERE id = :historyId")
    fun getHistory(historyId: Int): Flow<History>

    @Delete
    suspend fun deleteHistory(historyList: List<History>)

}