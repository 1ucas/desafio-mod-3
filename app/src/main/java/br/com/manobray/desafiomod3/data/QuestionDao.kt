package br.com.manobray.desafiomod3.ui.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface QuestionDao {

    @Query("SELECT * FROM question")
    fun getAll(): List<QuestionEntity>
}