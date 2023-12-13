package com.example.kingsmen.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kingsmen.data.model.ModelHistoryRecords

@Dao
interface Da02 {
    @Query("SELECT * FROM modelhistoryrecords ORDER BY id ")
    fun getAll():List<ModelHistoryRecords>
    @Query("SELECT * FROM MODELHISTORYRECORDS WHERE id=:taskId")
    fun getById(taskId: Int): List<ModelHistoryRecords>

    @Insert
    fun insert(modelHistoryRecords: ModelHistoryRecords)

    @Delete
    fun delete(modelHistoryRecords: ModelHistoryRecords)
}