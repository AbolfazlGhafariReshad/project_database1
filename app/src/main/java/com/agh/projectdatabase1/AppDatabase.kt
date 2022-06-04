package com.agh.projectdatabase1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [phone::class],
    version = 2
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun phonedao(): phonedao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "phone.db"
        )
            .allowMainThreadQueries()
            .build()
    }

}