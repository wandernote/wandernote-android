package com.app.wandernote.di

import com.app.wandernote.App
import dagger.Component

@Component(
    modules = [AppModule::class]
)

interface AppComponent {

    fun inject(application: App)

}