package com.example.kingsmen.data.remote

import com.example.kingsmen.core.BaseRemoteDataSource
import com.example.kingsmen.data.model.JournalModel
import com.example.kingsmen.data.model.ModelBarberShop
import com.example.kingsmen.data.model.ModelMasters
import com.example.kingsmen.data.model.ModelPortfolio
import com.example.kingsmen.data.model.ProductModel
import com.example.kingsmen.data.network.ApiService

class RemoteDataSource(private val apiService: ApiService):BaseRemoteDataSource() {
    suspend fun getBarberShop():Result<ModelBarberShop>{
        return getResult {
         apiService.getBarberShop()
        }
    }
    suspend fun getProduct():Result<ProductModel>{
        return getResult {
            apiService.getProduct()
        }
    }
    suspend fun getPortfolio(master:Int):Result<ModelPortfolio>{
        return getResult {
            apiService.getPortfolio(master)
        }
    }
    suspend fun getMasters():Result<ModelMasters>{
        return getResult {
            apiService.getMasters()
        }
    }
    suspend fun getJournal(topic:Int):Result<JournalModel>{
       return getResult {
            apiService.getJournal(topic)
        }
    }
}