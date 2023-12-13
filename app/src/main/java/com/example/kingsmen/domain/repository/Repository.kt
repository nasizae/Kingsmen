package com.example.kingsmen.domain.repository

import com.example.kingsmen.data.model.JournalModelItem
import com.example.kingsmen.data.model.ModelMasters
import com.example.kingsmen.data.model.ModelPortfolio
import com.example.kingsmen.data.model.PostReviws
import com.example.kingsmen.data.model.ProductModel
import com.example.kingsmen.data.remote.RemoteDataSource


class Repository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getReview(master: Int): Result<PostReviws> {
        return remoteDataSource.getReviews(master)
    }
    suspend fun postReview(
        client: Int,
        master: Int,
        rate: Int,
        text: String,
        date_time: String
    ): Result<PostReviws> {
        return remoteDataSource.postReview(client, master, rate, text, date_time)
    }
    suspend fun getProduct(): Result<ProductModel> {
        return remoteDataSource.getProduct()
    }

    suspend fun getPortfolio(master: Int): Result<ModelPortfolio> {
        return remoteDataSource.getPortfolio(master)
    }

    suspend fun getMaster(): Result<ModelMasters> {
        return remoteDataSource.getMasters()
    }

    suspend fun getJournal(topic: Int): Result<JournalModelItem> {
        return remoteDataSource.getJournal(topic)
    }

}