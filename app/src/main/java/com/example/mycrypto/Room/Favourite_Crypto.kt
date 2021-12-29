package com.example.mycrypto.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")    // After this annotation a table will be created in sqlite(DataBase).
class Favourite_Crypto(@ColumnInfo(name = "text") val text: String) {
    @PrimaryKey(autoGenerate = true)
    var id =
        0  //As the PrimaryKey is autoGenerate we don't need to pass argument that's why it is outside

}