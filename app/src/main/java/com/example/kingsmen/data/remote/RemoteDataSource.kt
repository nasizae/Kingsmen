package com.example.kingsmen.data.remote

import com.example.kingsmen.core.BaseRemoteDataSource
import com.example.kingsmen.data.model.JournalModelItem
import com.example.kingsmen.data.model.ModelBarberShop
import com.example.kingsmen.data.model.ModelMasters
import com.example.kingsmen.data.model.ModelPortfolio
import com.example.kingsmen.data.model.PostReviws
import com.example.kingsmen.data.model.ProductModel
import com.example.kingsmen.data.network.ApiService

class RemoteDataSource(private val apiService: ApiService):BaseRemoteDataSource() {
    suspend fun getBarberShop():Result<ModelBarberShop>{
        return getResult {
         apiService.getBarberShop()
        }
    }
    suspend fun postReview(
        client: Int,
        master: Int,
        rate: Int,
        text: String,
        date_time: String
    ): Result<PostReviws> {
        return getResult {
            apiService.postReviews(client, master, rate, text, date_time)
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
    suspend fun getJournal(topic:Int):Result<JournalModelItem>{
       return getResult {
            apiService.getJournal(topic)
        }
    }

    suspend fun getReviews(master:Int):Result<PostReviws>{
        return getResult {
            apiService.getReview(master)
        }
    }
}