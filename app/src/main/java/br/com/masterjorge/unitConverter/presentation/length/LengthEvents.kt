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
}