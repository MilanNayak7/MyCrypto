package com.example.mycrypto.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavouriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favouriteCrypto: Favourite_Crypto)

    @Delete
    suspend fun delete(favouriteCrypto: Favourite_Crypto)

    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Favourite_Crypto>>

}