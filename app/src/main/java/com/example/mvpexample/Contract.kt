package com.example.mvpexample

import com.example.mvpexample.api.PostResponse
import com.example.mvpexample.database.PostRoom
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface Contract {

    interface MainView {
        fun setData(data : ArrayList<PostResponse>)
    }

    interface ContractPresenter : MainContractPresenter<MainView>

    interface Model{
        fun request() : Observable<ArrayList<PostResponse>>

        fun setToDB(posts : ArrayList<PostResponse>)
        fun getFromDb() : Single<List<PostRoom>>
    }
}