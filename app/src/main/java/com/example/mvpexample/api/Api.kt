package com.example.mvpexample.api

import android.widget.ArrayAdapter
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface Api {

    @GET("/posts")
    fun getRequest(): Observable<ArrayList<PostResponse>>

}