package br.com.manobray.desafiomod3.ui.main.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuestionsViewModel(private val questions: List<Question>) : ViewModel() {

    private var answers = mutableListOf<Boolean>()
    private var currentQuestion = 0
    var finalResult: Int? = null
    var liveData = MutableLiveData<Unit>()

    private fun answerQuestion(question: Int, answer: Boolean) {
        answers.add(answer)
        if (question == questions.size - 1) {
            liveData.value = Unit
        }
    }

}
