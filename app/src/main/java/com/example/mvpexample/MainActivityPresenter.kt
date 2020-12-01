package com.example.mvpexample

import android.content.Context
import com.example.mvpexample.api.PostResponse
import com.example.mvpexample.base.App
import com.example.mvpexample.database.PostRoom
import javax.inject.Inject

class MainActivityPresenter constructor(context : Context) : Contract.ContractPresenter {

    init {
        App[App[context]].injector?.inject(this)
    }

    @Inject
    lateinit var model : MainActivityModel


    private lateinit var view: Contract.MainView

    override fun get() {
        model.request().subscribe{ response: ArrayList<PostResponse> -> this.setData(response) }
    }

    override fun attach(view: Contract.MainView) {
        this.view = view
    }

    private fun setData(response: ArrayList<PostResponse>){
        model.setToDB(response)
        view.setData(response)
    }

}