package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {
    abstract fun itemDao() : ItemDao

    companion object {
        @Volatile //the variable value never cached and it's always up to date, It means that changes made by one thread to Instance are immediately visible to all other threads.
        private var Instance : InventoryDatabase? = null

        fun getDatabase(context: Context) : InventoryDatabase {
            return Instance ?: synchronized(this) { //synchronized makes sure the database initialized once
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}