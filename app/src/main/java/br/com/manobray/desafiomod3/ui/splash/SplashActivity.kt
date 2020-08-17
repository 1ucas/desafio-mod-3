package br.com.manobray.desafiomod3.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.manobray.desafiomod3.R
import br.com.manobray.desafiomod3.ui.main.MainActivity
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
                Toast.makeText(this@SplashActivity, "Abrindo Nova Activity", Toast.LENGTH_SHORT).show()
                openNextActivity()
            }
        }, 2000)
    }

    fun openNextActivity() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(MainActivity.PARAMS_KEY, "Mensagem Legal")
        }
        startActivity(intent)
    }
}
