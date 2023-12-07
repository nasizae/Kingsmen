package com.example.kingsmen.presentation.ui.home.barber.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kingsmen.core.BaseViewModel
import com.example.kingsmen.data.model.ModelPortfolio
import com.example.kingsmen.domain.repository.Repository

class PortfolioViewModel(private val repository: Repository):BaseViewModel() {
    private val _getPortfolio=MutableLiveData<ModelPortfolio>()
    val getPortfolio:LiveData<ModelPortfolio> get() = _getPortfolio

    fun getPortfolio(master: Int)=doOperation(
        operation = {repository.getPortfolio(master)},
        success = {_getPortfolio.postValue(it)}
    )
}