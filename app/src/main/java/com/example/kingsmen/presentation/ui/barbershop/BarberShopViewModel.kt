package com.example.kingsmen.presentation.ui.barbershop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kingsmen.core.BaseViewModel
import com.example.kingsmen.data.model.ModelBarberShop
import com.example.kingsmen.domain.repository.Repository

class BarberShopViewModel(private val repository: Repository):BaseViewModel() {
    private val _barbershop=MutableLiveData<ModelBarberShop>()
    val barbershop:LiveData<ModelBarberShop> get() = _barbershop

    fun getBarberShop()=doOperation(
        operation ={repository.getBarberShop()},
        success ={_barbershop.postValue(it)}
    )

}