package com.example.kingsmen.presentation.ui.home.journal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kingsmen.core.BaseViewModel
import com.example.kingsmen.data.model.JournalModel
import com.example.kingsmen.domain.repository.Repository

class JournalViewModel(private val repository: Repository):BaseViewModel() {

    private val _journal=MutableLiveData<JournalModel>()
    val journal :LiveData<JournalModel> get() = _journal

    fun getJournal(topic: Int)=doOperation(
        operation = {repository.getJournal(topic)},
        success = {_journal.postValue(it)}
    )
}