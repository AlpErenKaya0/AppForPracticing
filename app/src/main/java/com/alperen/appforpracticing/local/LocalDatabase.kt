package com.alperen.appforpracticing.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LocalDBTable::class], version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun localDao(): LocalDBDao
    //2. bir tablo kullanılıyorsa, buraya Dao'sunun eklenmesi yeterli olacaktır
    companion object {
        @Volatile
        private var INSTANCE: LocalDatabase? = null
        private val lock = Any()
        operator fun invoke(context: Context) = INSTANCE?: synchronized(lock) {
            INSTANCE ?: makeDatabase(context).also {
                INSTANCE = it
            }
        }
        private fun makeDatabase (context: Context) = Room.databaseBuilder(
            context.applicationContext, LocalDatabase::class.java,"local_database"
        ).build()
    }
}
