package br.com.masterjorge.unitConverter.data.remote

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.masterjorge.unitConverter.data.remote.interfaces.HistoryDao
import br.com.masterjorge.unitConverter.data.remote.models.History

@Database(entities = [History::class], version = 1)
abstract class UnitConverterDb: RoomDatabase() {

    abstract val historyDao: HistoryDao
}