package com.example.mvpexample

interface MainContractPresenter<V> {
    fun get()

    fun attach(view : V)
}