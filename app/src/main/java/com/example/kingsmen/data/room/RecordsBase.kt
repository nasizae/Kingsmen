package com.example.kingsmen.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kingsmen.data.model.ModelHistoryRecords

@Database(entities = [ModelHistoryRecords::class], version = 1)
abstract class RecordsBase:RoomDatabase() {
    abstract fun records():Da02


}