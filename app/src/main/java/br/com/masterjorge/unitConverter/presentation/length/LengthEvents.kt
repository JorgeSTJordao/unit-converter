package br.com.masterjorge.unitConverter.presentation.length

import br.com.masterjorge.unitConverter.domain.models.LengthPattern

sealed interface LengthEvents {
    data class ChangeUnit1(val unit1: LengthPattern): LengthEvents
    data class ChangeUnit2(val unit2: LengthPattern): LengthEvents
    data object Decimal: LengthEvents
    data object Delete: LengthEvents
    data object Clear: LengthEvents
    data class ChangeValue(val value: String): LengthEvents
    data object Convert: LengthEvents
    data object DeleteAll: LengthEvents
}

object LengthMap {
    val mapLength = listOf(
        LengthPattern("km", 1000f),
        LengthPattern("hm", 100f),
        LengthPattern("dam", 10f),
        LengthPattern("m", 1f),
        LengthPattern("dm", 0.1f),
        LengthPattern("cm", 0.01f),
        LengthPattern("mm", 0.001f),
    )
}