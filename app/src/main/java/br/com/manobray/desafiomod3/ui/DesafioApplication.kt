package br.com.manobray.desafiomod3.ui

import android.app.Application
import br.com.manobray.desafiomod3.ui.main.mainDIModules
import br.com.manobray.desafiomod3.ui.main.mainDIModulesList
import org.koin.core.context.startKoin

class DesafioApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(mainDIModules)
            )
        }
    }
}