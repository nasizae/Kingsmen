package com.example.kingsmen

import android.app.Application
import androidx.room.Room
import com.example.kingsmen.data.room.Database
import com.example.kingsmen.data.room.RecordsBase

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        database=Room.databaseBuilder(
            applicationContext,Database::class.java,"database_product"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        database1=Room.databaseBuilder(
            applicationContext,RecordsBase::class.java,"records"
        ).allowMainThreadQueries().build()
    }
    companion object{
        lateinit var database: Database
        lateinit var database1: RecordsBase
    }
}