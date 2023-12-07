package com.example.kingsmen.presentation.ui.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kingsmen.core.BaseViewModel
import com.example.kingsmen.data.model.ProductModel
import com.example.kingsmen.domain.repository.Repository

class ShopViewModel (private val repository: Repository): BaseViewModel() {
    private val _product=MutableLiveData<ProductModel>()
    val product:LiveData<ProductModel> get() = _product

    fun getProduct()=doOperation(
        operation = {repository.getProduct()},
        success = {_product.postValue(it)}
    )

}