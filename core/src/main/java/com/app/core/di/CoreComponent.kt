package com.app.core.di

import android.content.Context
import com.app.core.di.modules.ContextModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ContextModule::class]
)
interface CoreComponent {
    fun context(): Context
}