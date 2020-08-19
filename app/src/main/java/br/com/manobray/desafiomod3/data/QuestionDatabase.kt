package br.com.manobray.desafiomod3.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(QuestionEntity::class), version = 1)
abstract class QuestionDatabase : RoomDatabase() {
    abstract fun questionDao() : QuestionDao
}