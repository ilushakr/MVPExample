package com.example.mvpexample.base

import android.app.Application
import android.content.Context
import com.example.mvpexample.api.Api
import com.example.mvpexample.modules.ApiModule
import com.example.mvpexample.modules.MvpModule
import com.example.mvpexample.modules.RoomModule

class App : Application() {

    private lateinit var api : Api

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    /*baseDI*/
    private var appComponent: DaggerComponent? = null
    val injector: DaggerComponent?
        get() {
            if (appComponent == null) {
                appComponent = DaggerDaggerComponent
                    .builder()
                    .apiModule(ApiModule(this))
                    .mvpModule(MvpModule(this))
                    .roomModule(RoomModule(this))
                    .build()
            }
            return appComponent
        }
    //
    companion object {
        var appContext: Context? = null
            private set
        private var api: Api? = null
        operator fun get(ctx: Context): App {
            return ctx.applicationContext as App
        }
    }
}