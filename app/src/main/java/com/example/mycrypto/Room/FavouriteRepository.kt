package com.example.mycrypto.Room

import androidx.lifecycle.LiveData

class FavouriteRepository(private val favouriteDao: FavouriteDao) {
    val allNotes:LiveData<List<Favourite_Crypto>> = favouriteDao.getAllNotes() // all the notes are getting using favouriteDao object.

    suspend fun insert(favouriteCrypto:Favourite_Crypto){
        favouriteDao.insert(favouriteCrypto)
    }

    suspend fun delete(favouriteCrypto:Favourite_Crypto){
        favouriteDao.delete(favouriteCrypto)
    }
}