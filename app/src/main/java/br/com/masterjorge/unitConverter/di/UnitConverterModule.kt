package br.com.masterjorge.unitConverter.di

import android.app.Application
import androidx.room.Room
import br.com.masterjorge.unitConverter.data.remote.UnitConverterDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UnitConverterModule {

    @Provides
    @Singleton
    fun providesRoom(app: Application): UnitConverterDb {
        return Room.databaseBuilder(
            app,
            UnitConverterDb::class.java,
            "unit_convert_db"
        ).build()
    }
}