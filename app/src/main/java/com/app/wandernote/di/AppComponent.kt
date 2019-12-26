package com.app.wandernote.di

import com.app.core.di.CoreComponent
import com.app.core.di.scopes.AppScope
import com.app.wandernote.App
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    fun inject(application: App)

}