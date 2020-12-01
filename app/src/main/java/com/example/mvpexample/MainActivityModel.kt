package com.example.mvpexample

import com.example.mvpexample.api.Api
import com.example.mvpexample.api.PostResponse
import com.example.mvpexample.database.PostRepository
import com.example.mvpexample.database.PostRoom
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityModel @Inject constructor() : Contract.Model {

    @Inject
    lateinit var api : Api

    @Inject
    lateinit var db : PostRepository

    override fun request(): Observable<ArrayList<PostResponse>> {
        return api.getRequest().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    override fun setToDB(posts: ArrayList<PostResponse>) {
        GlobalScope.launch {
            db.insertPosts(posts)
        }
    }

    override fun getFromDb(): Single<List<PostRoom>> {
        return db.getPosts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }


}