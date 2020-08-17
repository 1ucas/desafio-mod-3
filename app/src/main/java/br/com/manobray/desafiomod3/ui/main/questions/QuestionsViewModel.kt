package br.com.manobray.desafiomod3.ui.main.questions

import androidx.lifecycle.ViewModel
import br.com.manobray.desafiomod3.ui.util.SingleLiveEvent
import java.lang.Exception
import kotlin.math.roundToInt

class QuestionsViewModel() : ViewModel() {

    private var answers = mutableListOf<Boolean>()
    private var result = 0.0
    private lateinit var questions: List<Question>

    var questionIndex = 0
    val currentQuestion = SingleLiveEvent<Question>()
    val finalResult = SingleLiveEvent<Int>()

    fun start(questions: List<Question>) {
        answers.clear()
        result = 0.0

        this.questions = questions
        questionIndex = 0

        currentQuestion.value = questions[questionIndex]
    }

    fun answerQuestion(answer: Boolean) {
        answers.add(answer)
        if (questionIndex == questions.size - 1) {
            calcFinalResult()
        } else {
            questionIndex++
            currentQuestion.value = questions[questionIndex]
        }
    }

    private fun calcFinalResult() {
        if(answers.size != questions.size) {
            throw Exception("Deu ruim")
        } else {
            questions.forEachIndexed { index, question ->
                if(question.answer == answers[index]) {
                    result += 1.0/questions.size
                }
            }
            finalResult.value = (result * 100).roundToInt()
        }
    }
}
