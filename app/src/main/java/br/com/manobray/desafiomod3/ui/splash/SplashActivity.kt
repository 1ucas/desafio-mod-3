package br.com.manobray.desafiomod3.ui.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.manobray.desafiomod3.R
import br.com.manobray.desafiomod3.ui.main.MainActivity
import br.com.manobray.desafiomod3.ui.main.mainDIModulesList
import br.com.manobray.desafiomod3.ui.main.questions.Question
import org.koin.core.context.loadKoinModules
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onStart() {
        super.onStart()
        Timer().schedule(timerTask {
            runOnUiThread {
                Toast.makeText(this@SplashActivity, "Abrindo Nova Activity", Toast.LENGTH_SHORT)
                    .show()
                openNextActivity()
            }
        }, 2000)
    }

    fun openNextActivity() {
        val questions = arrayListOf<Question>(
            Question("Pergunta 1: A linguagem oficial para desenvolvimento Android Nativo pela Google é a Kotlin", true),
            Question("Pergunta 2: O processo de publicação do aplicativo na Google Play é gratuito", false),
            Question("Pergunta 3: O Brasil possui uma população de quase 210 milhões", true),
            Question("Pergunta 4: Flutter é uma dos frameworks de desenvolvimento mobile", true),
            Question("Pergunta 5: A linguagem de programação do Flutter é o Dart", true),
            Question("Pergunta 6: O Flutter possui interoperabilidade e pode ter projetos em Java e Dart", false),
            Question("Pergunta 7: React-Native é uma plataforma para desenvolvimento de aplicativos móveis", true),
            Question("Pergunta 8: O Kotlin possui interoperabilidade oque possibilita implementar projetos em Java e Kotlin", true)
            )
        val intent = Intent(this, MainActivity::class.java).apply {
            putParcelableArrayListExtra(MainActivity.PARAMS_KEY, questions)
        }
        finish()
        startActivity(intent)
    }
}
