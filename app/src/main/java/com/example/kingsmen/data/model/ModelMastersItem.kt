package com.example.kingsmen.data.model

import java.io.Serializable

data class ModelMastersItem(
    val id: Int,
    val login: String,
    val rate: Double,
    val source_img: String
):Serializable