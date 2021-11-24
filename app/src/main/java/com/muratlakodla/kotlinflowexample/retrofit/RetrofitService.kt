package com.muratlakodla.kotlinflowexample.retrofit

import com.muratlakodla.kotlinflowexample.util.API_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitService {
    companion object {
        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(API_URL)
            .build()

        val retrofitService: RetrofitApi by lazy {
            retrofit.create(RetrofitApi::class.java)
        }
    }
}