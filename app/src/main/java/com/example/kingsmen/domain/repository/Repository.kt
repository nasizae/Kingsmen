package com.example.kingsmen.domain.repository

import com.example.kingsmen.data.model.JournalModel
import com.example.kingsmen.data.model.ModelBarberShop
import com.example.kingsmen.data.model.ModelMasters
import com.example.kingsmen.data.model.ModelPortfolio
import com.example.kingsmen.data.model.ProductModel
import com.example.kingsmen.data.remote.RemoteDataSource


class Repository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getBarberShop(): Result<ModelBarberShop> {
        return remoteDataSource.getBarberShop()
    }

    suspend fun getProduct(): Result<ProductModel> {
        return remoteDataSource.getProduct()
    }
     suspend fun getPortfolio(master:Int):Result<ModelPortfolio>{
         return remoteDataSource.getPortfolio(master)
     }

    suspend fun getMaster():Result<ModelMasters>{
        return remoteDataSource.getMasters()
    }

    suspend fun getJournal(topic: Int):Result<JournalModel>{
        return remoteDataSource.getJournal(topic)
    }
}