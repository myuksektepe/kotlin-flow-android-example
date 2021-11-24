package com.muratlakodla.kotlinflowexample.repository

import android.util.Log
import com.muratlakodla.kotlinflowexample.model.CommentModel
import com.muratlakodla.kotlinflowexample.model.ResultData
import com.muratlakodla.kotlinflowexample.retrofit.RetrofitApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CommentRepository(private val retrofitApi: RetrofitApi) {

    suspend fun fetchAllComments(): Flow<ResultData<List<CommentModel>>> = flow {

        emit(ResultData.LOADING())

        try {
            // Bütün yorumları getir
            val comments = retrofitApi.getComments()

            // Flow'a gönder
            emit(ResultData.SUCCESS(comments))

        } catch (e: Exception) {
            Log.e("applog", "CommentRepository ${e.message}")
            emit(ResultData.FAIL(e, e.message.toString()))
        }

    }.flowOn(Dispatchers.IO)
}