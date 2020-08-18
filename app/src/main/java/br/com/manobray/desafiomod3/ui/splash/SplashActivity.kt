package br.com.manobray.desafiomod3.ui.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.manobray.desafiomod3.R
import br.com.manobray.desafiomod3.ui.data.DataManager
import br.com.manobray.desafiomod3.ui.main.MainActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onStart() {
        super.onStart()
        val isFirstOpen = DataManager().getFirstOpen(this)
        if(!isFirstOpen) {
            DataManager().saveFirstOpen(this)
            Timer().schedule(timerTask {
                runOnUiThread {
                    Toast.makeText(this@SplashActivity, "Abrindo Nova Activity", Toast.LENGTH_SHORT)
                        .show()
                    openNextActivity()
                }
            }, 5000)
        } else {
            openNextActivity()
        }
    }

    fun openNextActivity() {

        GlobalScope.launch {
            val questions = DataManager().getQuestions()
            val intent = Intent(this@SplashActivity, MainActivity::class.java).apply {
                putParcelableArrayListExtra(MainActivity.PARAMS_KEY, questions)
            }
            runOnUiThread {
                finish()
                startActivity(intent)
            }
        }


    }
}
