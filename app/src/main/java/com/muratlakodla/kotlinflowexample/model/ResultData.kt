package com.muratlakodla.kotlinflowexample.model

sealed class ResultData<out R> {
    class LOADING<T> : ResultData<T>()
    data class SUCCESS<out T>(val data: T) : ResultData<T>()
    data class FAIL(val throwable: Throwable, val message: String) : ResultData<Nothing>()
}