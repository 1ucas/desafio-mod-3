package br.com.manobray.desafiomod3.ui.main

import br.com.manobray.desafiomod3.ui.main.questions.QuestionsViewModel
import br.com.manobray.desafiomod3.ui.main.result.ResultViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val mainDIModulesList : List<Module>
    get() = listOf()

val mainDIModules = module {

    viewModel { MainViewModel() }
    viewModel { QuestionsViewModel() }
    viewModel { ResultViewModel() }

}