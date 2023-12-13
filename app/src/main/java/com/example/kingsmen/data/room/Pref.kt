package com.example.kingsmen.data.room

import android.content.Context
import com.example.kingsmen.data.model.ModelHistoryRecords
import com.google.gson.Gson

class Pref(private val context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val gson=Gson()
    fun saveRecords(modelHistoryRecords: ModelHistoryRecords){
        val json=gson.toJson(modelHistoryRecords)
        pref.edit().putString(SAVE_NAME,json).apply()
    }
    companion object {
        const val PREF_NAME = "pref_name"
        const val SHOWED_KEY = "seen_key"
        const val SAVE_NAME = "save_name"
        const val IMAGE_KEY = "image_key"
    }
}