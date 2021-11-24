package com.muratlakodla.kotlinflowexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratlakodla.kotlinflowexample.model.CommentModel
import com.muratlakodla.kotlinflowexample.model.ResultData
import com.muratlakodla.kotlinflowexample.repository.CommentRepository
import com.muratlakodla.kotlinflowexample.retrofit.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val retrofitApi = RetrofitService.retrofitService

    private val commentRepository = CommentRepository(retrofitApi)

    private val _comments: MutableLiveData<ResultData<List<CommentModel>>> = MutableLiveData()
    val comments: LiveData<ResultData<List<CommentModel>>>
        get() = _comments


    fun fetchAllComments() {
        viewModelScope.launch(Dispatchers.IO) {

            commentRepository.fetchAllComments().collect {
                _comments.postValue(it)
            }

            /*
            // Loading
            _comments.postValue(ResultData.LOADING())

            commentRepository.fetchAllComments().catch {
                // Fail
                _comments.postValue(ResultData.FAIL(it, it.message.toString()))
            }.collect {
                // Success
                _comments.postValue(it)
            }
             */
        }
    }

}