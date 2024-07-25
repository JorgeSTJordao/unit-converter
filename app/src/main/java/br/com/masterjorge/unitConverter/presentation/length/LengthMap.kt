package br.com.masterjorge.unitConverter.presentation.length

import br.com.masterjorge.unitConverter.domain.models.LengthPattern

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
