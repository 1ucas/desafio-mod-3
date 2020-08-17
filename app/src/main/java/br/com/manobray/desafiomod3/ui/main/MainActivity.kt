package br.com.manobray.desafiomod3.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.manobray.desafiomod3.R
import br.com.manobray.desafiomod3.ui.main.questions.QuestionsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    private fun processParams() {
        intent.extras?.getString(PARAMS_KEY)?.let {
            Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        val PARAMS_KEY = "MAIN_ACT_PARAM"
        val RESULT_KEY = "ANSWERS_RESULT_KEY"
    }
}
