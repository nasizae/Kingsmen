package com.example.kingsmen.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kingsmen.data.model.ProductModelItem

@Dao
interface Dao {
    @Query("SELECT * FROM productmodelitem ORDER BY id ")
    fun getAll():List<ProductModelItem>
    @Query("SELECT * FROM productmodelitem WHERE id=:taskId")
    fun getById(taskId: Int): List<ProductModelItem>

    @Insert
    fun insert(productModelItem: ProductModelItem)

    @Delete
    fun gelete(productModelItem: ProductModelItem)


}