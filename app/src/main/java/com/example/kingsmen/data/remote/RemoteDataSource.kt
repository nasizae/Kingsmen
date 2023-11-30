package com.example.kingsmen.data.remote

import com.example.kingsmen.core.BaseRemoteDataSource
import com.example.kingsmen.data.model.ModelBarberShop
import com.example.kingsmen.data.network.ApiService

class RemoteDataSource(private val apiService: ApiService):BaseRemoteDataSource() {

    suspend fun getBarberShop():Result<ModelBarberShop>{
        return getResult {
         apiService.getBarberShop()
        }
    }
}