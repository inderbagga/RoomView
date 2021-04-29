package com.inderbagga.roomview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.inderbagga.roomview.repo.WordRepository
import com.inderbagga.roomview.repo.room.entity.Word
import kotlinx.coroutines.launch

class WordViewModel(private val repo:WordRepository) : ViewModel()
{

    val words: LiveData<List<Word>> =repo.allWords.asLiveData()


    fun insert(word: Word)=viewModelScope.launch{

        repo.insert(word)
    }


}