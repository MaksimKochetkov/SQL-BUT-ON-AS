package com.example.prakt15_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [accounts::class, boxes::class], version = 3)
abstract class MainDB: RoomDatabase() {
    abstract fun getDao(): Dao

    companion object {
        fun createDB(context: Context): MainDB {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDB::class.java,
                "test.bd"
            ).fallbackToDestructiveMigration().build()
        }
    }
}