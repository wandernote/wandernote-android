package com.mucahitkambur.dynamicfeature.home.ui

import com.app.commons.ui.base.BaseFragment
import com.app.wandernote.App
import com.mucahitkambur.dynamicfeature.home.R
import com.mucahitkambur.dynamicfeature.home.databinding.FragmentHomeBinding
import com.mucahitkambur.dynamicfeature.home.ui.di.DaggerHomeComponent
import com.mucahitkambur.dynamicfeature.home.ui.di.HomeModule

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
