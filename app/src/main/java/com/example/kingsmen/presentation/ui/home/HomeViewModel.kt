package com.example.kingsmen.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kingsmen.core.BaseViewModel
import com.example.kingsmen.data.model.ModelMasters
import com.example.kingsmen.domain.repository.Repository

class HomeViewModel(private val repository: Repository) : BaseViewModel() {

    private val _masters = MutableLiveData<ModelMasters>()
    val masters :LiveData<ModelMasters> get() = _masters

    fun getMasters()=doOperation(
        operation = {repository.getMaster()},
        success = {_masters.postValue(it)}
    )
}