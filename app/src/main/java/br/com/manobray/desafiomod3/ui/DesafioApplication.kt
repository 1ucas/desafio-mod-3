package br.com.manobray.desafiomod3.ui

import android.app.Application
import androidx.room.Room
import br.com.manobray.desafiomod3.ui.data.QuestionDBHelper
import br.com.manobray.desafiomod3.ui.data.QuestionDatabase
import br.com.manobray.desafiomod3.ui.main.mainDIModules
import org.koin.core.context.startKoin

class DesafioApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(mainDIModules)
            )
        }

        QuestionDBHelper.db = Room.databaseBuilder(
            applicationContext,
            QuestionDatabase::class.java, "desafio")
            .createFromAsset("database/desafio.db")
            .build()
    }
}