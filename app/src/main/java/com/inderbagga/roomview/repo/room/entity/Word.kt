package com.inderbagga.roomview.repo.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)
