package com.example.mvpexample.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PostRoom::class],
    version = 1,
    exportSchema = false
)
abstract class DataBase : RoomDatabase() {
    abstract fun postDao(): PostDao
}