package br.com.masterjorge.unitConverter.domain.use_cases

import br.com.masterjorge.unitConverter.domain.models.LengthPattern

class CalculateLength {

    operator fun invoke(unit1: LengthPattern, unit2: LengthPattern, value: Float): Float =
        value * unit1.value/unit2.value
}