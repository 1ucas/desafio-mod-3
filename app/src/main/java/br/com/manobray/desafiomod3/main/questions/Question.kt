package br.com.manobray.desafiomod3.main.questions

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question(
    val title: String,
    val answer: Boolean
) : Parcelable