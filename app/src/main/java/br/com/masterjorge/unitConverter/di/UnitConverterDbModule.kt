package br.com.masterjorge.unitConverter.di

import br.com.masterjorge.unitConverter.data.remote.UnitConverterDb
import br.com.masterjorge.unitConverter.data.repositories.HistoryRepositoryImpl
import br.com.masterjorge.unitConverter.domain.repositories.HistoryRepository
import br.com.masterjorge.unitConverter.domain.use_cases.CalculateLength
import br.com.masterjorge.unitConverter.domain.use_cases.CheckInput
import br.com.masterjorge.unitConverter.domain.use_cases.LengthUseCase
import br.com.masterjorge.unitConverter.domain.use_cases.RecordUseCase
import br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases.DeleteAll
import br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases.GetAllHistories
import br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases.GetHistory
import br.com.masterjorge.unitConverter.domain.use_cases.history_use_cases.InsertHistory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UnitConverterDbModule {

    @Provides
    @Singleton
    fun providesHistoryRepository(unitConverterDb: UnitConverterDb): HistoryRepository {
        return HistoryRepositoryImpl(unitConverterDb.historyDao)
    }

    @Provides
    @Singleton
    fun providesLengthUseCase(historyRepository: HistoryRepository): LengthUseCase{
        return LengthUseCase(
            checkInput = CheckInput(),
            calculateLength = CalculateLength(),
            insertHistory = InsertHistory(historyRepository),
        )
    }

    @Provides
    @Singleton
    fun provideRecordUseCase(historyRepository: HistoryRepository): RecordUseCase{
        return RecordUseCase(
            getAllHistories = GetAllHistories(historyRepository),
            getHistory = GetHistory(historyRepository),
            deleteAll = DeleteAll(historyRepository)
        )
    }
}