package br.com.manobray.desafiomod3.ui.splash

import android.R
import android.content.Context

import android.content.SharedPreferences
import br.com.manobray.desafiomod3.ui.data.QuestionDBHelper
import br.com.manobray.desafiomod3.ui.main.questions.Question
import java.util.ArrayList


class DataManager {

    private val preferencesKey = "OPEN_KEY"
    private val firstOpenKey = "firstOpen"

    fun getFirstOpen(context: Context) : Boolean {
        val sharedPreferences = context.getSharedPreferences(preferencesKey, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(firstOpenKey, false)
    }

    fun saveFirstOpen(context: Context) {
        val sharedPreferences = context.getSharedPreferences(preferencesKey, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean(firstOpenKey, true)
        editor.apply()
    }

    fun getQuestions() : ArrayList<Question> {
        val questionsDB = QuestionDBHelper.db.questionDao().getAll()
        val parsedQuestions = questionsDB.map { e -> Question(e.title ?: "", e.answer == 1) }
        return ArrayList(parsedQuestions)
    }
}