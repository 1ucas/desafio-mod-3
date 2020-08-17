package br.com.manobray.desafiomod3.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.manobray.desafiomod3.R
import br.com.manobray.desafiomod3.ui.main.questions.Question
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        processParams()

        setContentView(R.layout.main_activity)
    }

    private val viewModel: MainViewModel by viewModel()

    private fun processParams() {
        intent.extras?.getParcelableArrayList<Question>(PARAMS_KEY)?.let {
            viewModel.questions = it
        } ?: run {
            viewModel.questions = emptyList()
        }
    }

    companion object {
        val PARAMS_KEY = "MAIN_ACT_PARAM"
        val RESULT_KEY = "ANSWERS_RESULT_KEY"
    }
}
