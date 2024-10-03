package br.com.masterjorge.unitConverter.presentation.length

import br.com.masterjorge.unitConverter.data.remote.models.History
import br.com.masterjorge.unitConverter.domain.models.LengthPattern

data class LengthState(
    var unit1: LengthPattern = LengthMap.mapLength[0],
    var unit2: LengthPattern = LengthMap.mapLength[3],
    var value: String = "",
    var result: Float = 0f,
    val valueError: String? = null,
    val readOnlyDelete: Boolean = true,
    val readOnlyDecimal: Boolean = false,
    val canAdd: Boolean = true,
    var recordList: List<History> = emptyList()
)