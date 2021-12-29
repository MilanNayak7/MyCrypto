package com.example.mycrypto.Room

//This class is basically use to hold the database
// This is the main access point for the database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Favourite_Crypto::class], version = 1, exportSchema = false) //The class must be annotated with a @Database annotation that includes an entities array that lists all of the data entities associated with the database.
abstract class FavouriteDatabase:RoomDatabase() {   //The class must be an abstract class that extends RoomDatabase.

    abstract  fun getNoteDao(): FavouriteDao  // For each DAO class that is associated with the database, the database class must define an abstract method that has zero arguments and returns an instance of the DAO class.

    companion object {
        // Singleton prevents multiple instances of database opening at the same time

        @Volatile
        private var INSTANCE: FavouriteDatabase? = null

        fun getDatabase(context: Context): FavouriteDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavouriteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}