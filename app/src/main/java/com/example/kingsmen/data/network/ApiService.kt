package com.example.kingsmen.data.network

import com.example.kingsmen.data.model.ModelBarberShop
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("get_barbershop")
   suspend fun getBarberShop():Response<ModelBarberShop>

}