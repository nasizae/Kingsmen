package com.example.kingsmen.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kingsmen.data.model.ProductModelItem

@Database(entities = [ProductModelItem::class], version = 1,)
abstract class Database :RoomDatabase() {
    abstract fun productDao() : Dao
}