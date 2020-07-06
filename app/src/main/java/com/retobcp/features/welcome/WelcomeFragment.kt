package com.retobcp.features.welcome

import android.os.Bundle
import android.view.View
import com.retobcp.R
import com.retobcp.features.base.BaseFragment
import com.retobcp.features.utils.navigateTo
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment : BaseFragment(){

    override fun getLayoutId() = R.layout.fragment_welcome

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        btnContinue?.setOnClickListener {
            navigateTo(R.id.action_welcomeFragment_to_exchangeFragment)
        }

        btnExit?.setOnClickListener {
            activity?.finish()
        }
    }



    fun convertirRomano(numero : Int) : Int{
        var numeroImpar = 1
        var suma = 0
        for( ind in 1..numero){
            numeroImpar += 2
            suma += numeroImpar
        }


        return suma
    }

    private fun ordenar(items: List<Int>) = items.sortedByDescending { it }
}