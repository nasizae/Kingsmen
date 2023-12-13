package com.example.kingsmen.data.network

import com.example.kingsmen.data.model.JournalModelItem
import com.example.kingsmen.data.model.ModelBarberShop
import com.example.kingsmen.data.model.ModelMasters
import com.example.kingsmen.data.model.ModelPortfolio
import com.example.kingsmen.data.model.PostReviws
import com.example.kingsmen.data.model.ProductModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("get_barbershop")
    suspend fun getBarberShop(): Response<ModelBarberShop>

    @GET("get_product")
    suspend fun getProduct(): Response<ProductModel>

    @GET("get_portfolio")
    suspend fun getPortfolio(
        @Query("master") master: Int
    ): Response<ModelPortfolio>


    @GET("get_masters")
    suspend fun getMasters():Response<ModelMasters>

    @GET("get_journal")
    suspend fun getJournal(
        @Query("topic") topic:Int
    ): Response<JournalModelItem>

    @GET("get_review")
    suspend fun getReview(
        @Query("master") master:Int
    ):Response<PostReviws>
    @FormUrlEncoded
    @POST("add_review_item")
    suspend fun postReviews(
        @Field("client") client: Int,
        @Field("master") master: Int,
        @Field("rate") rate: Int,
        @Field("text") text: String,
        @Field("date_time") date_time: String
    ): Response<PostReviws>



}