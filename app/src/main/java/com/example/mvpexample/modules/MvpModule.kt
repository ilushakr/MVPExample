package com.example.mvpexample.modules

import android.app.Application
import android.content.Context
import com.example.mvpexample.Contract
import com.example.mvpexample.MainActivityModel
import com.example.mvpexample.MainActivityPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MvpModule(private val app: Application){

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideContractPresenter(context: Context): Contract.ContractPresenter {
        return MainActivityPresenter(context)
    }

    @Provides
    @Singleton
    fun provideMainActivityContractModel(): Contract.Model {
        return MainActivityModel()
    }
}