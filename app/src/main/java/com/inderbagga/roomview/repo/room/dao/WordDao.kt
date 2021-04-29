package com.inderbagga.roomview.repo.room.dao

import androidx.room.*
import com.inderbagga.roomview.repo.room.entity.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {


    @Query("SELECT * FROM words_table ORDER BY word ASC")
    fun getAscendingWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM words_table")
    suspend fun deleteAll()
}