package com.mucahitkambur.dynamicfeature.home.ui.di

import com.app.commons.ui.extensions.viewModel
import com.app.core.di.scopes.FeatureScope
import com.mucahitkambur.dynamicfeature.home.ui.HomeFragment
import com.mucahitkambur.dynamicfeature.home.ui.HomeViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeModule (val fragment: HomeFragment) {

    @Provides
    @FeatureScope
    fun providesHomeViewModel() = fragment.viewModel {
        HomeViewModel()
    }
}