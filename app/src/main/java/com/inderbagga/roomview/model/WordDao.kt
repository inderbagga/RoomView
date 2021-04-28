package com.inderbagga.roomview.model

import androidx.room.*

@Dao
interface WordDao {


    @Query("SELECT * FROM words_table ORDER BY word ASC")
    fun getAscendingWords(): List<Word>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM words_table")
    suspend fun deleteAll()
}