package com.example.mycrypto.Room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: FavouriteRepository
    val allNotes: LiveData<List<Favourite_Crypto>>

    init {
        val dao = FavouriteDatabase.getDatabase(application).getNoteDao()
        repository = FavouriteRepository(dao)
        allNotes = repository.allNotes
    }

    fun deleteNote(favouriteCrypto: Favourite_Crypto) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(favouriteCrypto)
    }

    fun insertNote(favouriteCrypto: Favourite_Crypto) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(favouriteCrypto)
    }
}