package com.example.kingsmen.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity
data class ProductModelItem(
    val description: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val price: Double,
    val source_img: String,
    val title: String,
    val volume: Int
):Serializable