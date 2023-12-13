package com.example.kingsmen.presentation.ui.home.barber.reviews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kingsmen.core.BaseViewModel
import com.example.kingsmen.data.model.PostReviws
import com.example.kingsmen.domain.repository.Repository

class ReviewViewModel(private val repository: Repository) : BaseViewModel() {

    private val _getReviews = MutableLiveData<PostReviws>()
    val reviews: LiveData<PostReviws> get() = _getReviews

    fun getReview(master: Int) = doOperation(
        operation = { repository.getReview(master) },
        success = { _getReviews.postValue(it) }
    )

    private val _postReviewResult = MutableLiveData<Boolean>()
    val postReviewResult: LiveData<Boolean> get() = _postReviewResult

     suspend fun postReview(
        client: Int,
        master: Int,
        rate: Int,
        text: String,
        date_time: String
    ) {
        repository.postReview(client, master, rate, text, date_time).let {
            _postReviewResult.postValue(it.isSuccess)
        }
    }

}


