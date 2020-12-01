package com.example.mvpexample.database

import com.example.mvpexample.api.PostResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class PostsDataSource @Inject constructor(private val postDao: PostDao) : PostRepository {

    override suspend fun insertPosts(posts: List<PostResponse>?) {
        if(posts != null && posts.isNotEmpty())
            posts.forEach{
                val postRoom = PostRoom(it.id, it.userId, it.title, it.body)
                postDao.insertPost(postRoom)
            }

    }

    override fun getPosts(): Single<List<PostRoom>> {
        return postDao.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}