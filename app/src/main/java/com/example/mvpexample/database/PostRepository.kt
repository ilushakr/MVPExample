package com.example.mvpexample.database

import com.example.mvpexample.api.PostResponse
import io.reactivex.rxjava3.core.Single

interface PostRepository {

    suspend fun insertPosts(posts : List<PostResponse>?)
    fun getPosts(): Single<List<PostRoom>>

}