package br.com.masterjorge.unitConverter.presentation.length

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.masterjorge.unitConverter.data.remote.models.History
import br.com.masterjorge.unitConverter.domain.use_cases.LengthUseCase
import br.com.masterjorge.unitConverter.domain.use_cases.RecordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelHome @Inject constructor(
    private val lengthUseCase: LengthUseCase,
    private val recordUseCase: RecordUseCase
): ViewModel() {


    var stateLength by mutableStateOf(LengthState())
        private set //Setter is private, but getter is public

    init {
        viewModelScope.launch {
            recordUseCase.getAllHistories.invoke().collect { record ->
                stateLength.recordList = record
            }
        }
    }


    fun onEvent(event: LengthEvents){
        when (event) {
            is LengthEvents.ChangeUnit1 -> {
                stateLength = stateLength.copy(
                    unit1 = event.unit1
                )
            }
            is LengthEvents.ChangeUnit2 -> {
                stateLength = stateLength.copy(
                        unit2 = event.unit2,
                    )
            }
            is LengthEvents.ChangeValue -> {
                if (stateLength.value.length < 8)
                    stateLength = stateLength.copy(
                        value = stateLength.value + event.value,
                        readOnlyDelete = false,
                        canAdd = true
                    )
                else if (stateLength.value.length == 8)
                    stateLength = stateLength.copy(
                        value = stateLength.value + event.value,
                        readOnlyDelete = false,
                        canAdd = false
                    )
            }
            is LengthEvents.Convert -> {
                val checkInput = lengthUseCase.checkInput(stateLength.value)

                    viewModelScope.launch {
                        if (checkInput.isCorrect) {
                            val deferred = async {
                                lengthUseCase.calculateLength(
                                    stateLength.unit1,
                                    stateLength.unit2,
                                    stateLength.value.toFloat()
                                )
                            }

                            stateLength = stateLength.copy(
                                result = deferred.await()
                            )

                            lengthUseCase.insertHistory(
                                History(
                                    stateLength.unit1.name,
                                    stateLength.unit2.name,
                                    deferred.await()
                                )
                            )
                        }
                        else {
                            stateLength  = stateLength.copy(
                                valueError = checkInput.isError
                            )
                        }
                    }

            }
            is LengthEvents.Clear -> { stateLength = stateLength.copy(
                value = "",
                result = 0f,
                readOnlyDecimal = false,
                readOnlyDelete = true,
                canAdd = true,
            )
            }
            is LengthEvents.Decimal -> {
                stateLength = stateLength.copy(
                        value = stateLength.value.plus("."),
                        readOnlyDecimal = true,
                        readOnlyDelete = false,
                        canAdd = true,
                    )
            }
            is LengthEvents.Delete -> {
                if (stateLength.value.isNotEmpty())
                    stateLength = if (stateLength.value.last() != '.')
                        stateLength.copy(
                            value = stateLength.value.removeLastChar(),
                            canAdd = true
                        )
                    else
                        stateLength.copy(
                            value = stateLength.value.removeLastChar(),
                            readOnlyDecimal = false,
                            canAdd = true
                        )
            }

            LengthEvents.DeleteAll -> {
                viewModelScope.launch {
                    recordUseCase.deleteAll.invoke()
                    stateLength = stateLength.copy(
                        recordList = emptyList()
                    )
                }
            }
        }
    }
}

fun String.removeLastChar(): String{
    if (this.isNotEmpty())
        return substring(0, length - 1)
    return this
}