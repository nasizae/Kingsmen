package com.example.kingsmen.domain.repository

import com.example.kingsmen.data.model.ModelBarberShop
import com.example.kingsmen.data.remote.RemoteDataSource


class Repository(private val remoteDataSource:RemoteDataSource) {

suspend fun getBarberShop():Result<ModelBarberShop>{
     return remoteDataSource.getBarberShop()
}

}