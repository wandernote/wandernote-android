package com.app.dynamicfeatures.home.ui.di

import com.app.core.di.CoreComponent
import com.app.core.di.scopes.FeatureScope
import com.app.dynamicfeatures.home.ui.HomeFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [HomeModule::class],
    dependencies =[CoreComponent::class]
)
interface HomeComponent {
    fun inject(homeFragment: HomeFragment)
}