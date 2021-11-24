package com.muratlakodla.kotlinflowexample.model

import java.io.Serializable

data class CommentModel(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String,
) : Serializable