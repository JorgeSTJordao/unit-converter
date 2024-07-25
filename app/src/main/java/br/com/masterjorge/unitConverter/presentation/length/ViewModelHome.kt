package br.com.masterjorge.unitConverter.presentation.length

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.masterjorge.unitConverter.data.remote.models.History
import br.com.masterjorge.unitConverter.domain.use_cases.LengthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelHome @Inject constructor(
    private val lengthUseCase: LengthUseCase
): ViewModel() {

    var stateLength by mutableStateOf(LengthState())
        private set //Setter is private, but getter is public

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
                stateLength = stateLength.copy(
                    value = stateLength.value + event.value,
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
                result = 0f
            )
            }
            is LengthEvents.Decimal -> {
                stateLength = stateLength.copy(
                    decimalReadOnly = true,
                    value = stateLength.value.plus(".")
                )
            }
            is LengthEvents.Delete -> {
                if (stateLength.value.last().equals("."))
                    stateLength = stateLength.copy(
                        value = stateLength.value.removeLastChar()
                    )
            }
        }
    }
}

fun String.removeLastChar(): String{
    if (this.isNotEmpty())
        return substring(0, length - 1)
    return this
}