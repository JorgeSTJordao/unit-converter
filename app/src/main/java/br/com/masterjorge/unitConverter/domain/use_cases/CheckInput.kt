package br.com.masterjorge.unitConverter.domain.use_cases

import br.com.masterjorge.unitConverter.domain.models.InputState

class CheckInput {

    operator fun invoke(input: String): InputState{
        if (input.isBlank()){
            return InputState(isError = "Campo vazio")
        }
        return InputState(isCorrect = true)
    }
}