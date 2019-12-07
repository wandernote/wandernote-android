package com.app.wandernote.di

import android.content.Context
import com.app.wandernote.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: App): Context = application.applicationContext

}