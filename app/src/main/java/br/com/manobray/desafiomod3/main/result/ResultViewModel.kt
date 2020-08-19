package br.com.manobray.desafiomod3.main.result

import androidx.lifecycle.ViewModel

class ResultViewModel : ViewModel() {

    var result = 0
    val resultText: String
        get() = "${result}% de acerto."
}
