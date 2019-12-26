package com.app.dynamicfeatures.home.ui

import com.app.commons.ui.base.BaseFragment
import com.app.wandernote.App
import com.app.dynamicfeatures.home.R
import com.app.dynamicfeatures.home.databinding.FragmentHomeBinding
import com.app.dynamicfeatures.home.ui.di.DaggerHomeComponent
import com.app.dynamicfeatures.home.ui.di.HomeModule

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home
) {

    override fun onInitDependencyInjection() {
        DaggerHomeComponent
            .builder()
            .coreComponent(App.coreComponent(requireContext()))
            .homeModule(HomeModule(this))
            .build()
            .inject(this)
    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }

}
