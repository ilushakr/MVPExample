package com.example.mvpexample.base

import com.example.mvpexample.MainActivity
import com.example.mvpexample.MainActivityModel
import com.example.mvpexample.MainActivityPresenter
import com.example.mvpexample.modules.ApiModule
import com.example.mvpexample.modules.MvpModule
import com.example.mvpexample.modules.RoomModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, MvpModule::class, RoomModule::class])
interface DaggerComponent {

    fun inject(act: MainActivity)
    fun inject(mainActivityPresenter: MainActivityPresenter)
    fun inject(mainActivityModel: MainActivityModel)
}