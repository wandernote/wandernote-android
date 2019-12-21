package com.app.wandernote

import android.app.Application
import android.content.Context
import com.app.core.di.CoreComponent
import com.app.core.di.DaggerCoreComponent
import com.app.core.di.modules.ContextModule
import com.app.wandernote.di.DaggerAppComponent

class App: Application() {

    lateinit var coreComponent: CoreComponent

    companion object {

        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as? App)?.coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initCoreDependencyInjection()
        initAppDependencyInjection()
    }

    private fun initAppDependencyInjection() {
        DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }

    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }
}