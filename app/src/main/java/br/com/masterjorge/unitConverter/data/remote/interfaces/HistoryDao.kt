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

    @Query("SELECT * FROM History ORDER BY id DESC LIMIT :limitItems OFFSET :offset")
    suspend fun getAllHistories(limitItems: Int, offset: Int): List<History>

    @Query("SELECT * FROM History WHERE id = :historyId")
    fun getHistory(historyId: Int): Flow<History>

    @Delete
    suspend fun deleteHistory(allRecords: List<History>)

}