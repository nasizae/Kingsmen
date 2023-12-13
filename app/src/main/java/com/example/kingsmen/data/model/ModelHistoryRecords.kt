package com.example.kingsmen.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ModelHistoryRecords(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val price: Int,
    val name:String,
    val image:String,
    val desc:String
)
