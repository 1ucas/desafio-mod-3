package br.com.manobray.desafiomod3.ui.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question")
data class QuestionEntity(
    @PrimaryKey val id: Int?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "answer") val answer: Int?
)