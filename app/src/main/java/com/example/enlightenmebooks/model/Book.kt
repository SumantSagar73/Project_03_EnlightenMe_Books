package com.example.enlightenmebooks.model

import android.annotation.SuppressLint
import androidx.annotation.BoolRes
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import com.example.enlightenmebooks.R

@SuppressLint("SupportAnnotationUsage")
data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val coverImageResId: Int,
   val synopsis: String,
)


