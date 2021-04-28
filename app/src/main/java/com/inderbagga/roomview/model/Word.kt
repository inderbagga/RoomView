package com.inderbagga.roomview.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class Word(@PrimaryKey(autoGenerate = true) val id: Int, @ColumnInfo(name = "word") val word: String)
