package com.retobcp.features.splash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer

import com.retobcp.R
import com.retobcp.features.base.BaseFragment
import com.retobcp.features.utils.navigateTo
import com.retobcp.features.utils.toast
import org.koin.android.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment(){

    private val viewModel by viewModel<SplashViewModel>()

    override fun getLayoutId() = R.layout.fragment_splash

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner,viewStateObserver)
        viewModel.syncCurrencies()
    }

    private val viewStateObserver = Observer<SplashViewState>{state ->
        when(state){
            is SplashViewState.Success -> syncSuccess()
            is SplashViewState.Failure -> toast(state.message)
        }
    }

    private fun syncSuccess() {
        navigateTo(R.id.action_splashFragment_to_welcomeFragment)
    }


}