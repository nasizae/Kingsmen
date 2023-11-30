package com.example.kingsmen.data.model
data class ModelBarberShop(
    val barberShopModel: List<BarberShopModel>
) {


    data class BarberShopModel(
        val address: String,
        val ftime: String,
        val id: Int,
        val source_img: String,
        val title: String,
        val ttime: String
    )
}