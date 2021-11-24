package com.muratlakodla.kotlinflowexample.retrofit

import com.muratlakodla.kotlinflowexample.model.CommentModel
import com.muratlakodla.kotlinflowexample.model.ResultData
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitApi {
    @GET("comments")
    suspend fun getComments(): List<CommentModel>

    @GET("comments/{id}")
    suspend fun getCommentById(@Path("id") id: Int): CommentModel
}