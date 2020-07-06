package com.retobcp.features.exchange

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.retobcp.R
import com.retobcp.features.base.BaseFragment
import com.retobcp.features.model.ExchangeModel
import com.retobcp.features.utils.Constant
import com.retobcp.features.utils.navigateTo
import com.retobcp.features.utils.toast
import kotlinx.android.synthetic.main.fragment_exchange.*
import org.koin.android.viewmodel.ext.android.viewModel

class ExchangeFragment : BaseFragment() {

    private val args get() = arguments?.let { ExchangeFragmentArgs.fromBundle(it) }

    private val viewModel by viewModel<ExchangeViewModel>()
    private lateinit var exchange1: ExchangeModel
    private lateinit var exchange2: ExchangeModel

    override fun getLayoutId() = R.layout.fragment_exchange

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        initViews()
    }

    private fun initViews() {
        btnCurrencyToSend?.setOnLongClickListener {
            sendToExchangeRate(Constant.EXCHANGE_TYPE1)
        }

        fabChangeCurrency?.setOnClickListener {
            val tmpExchange1 = exchange1.copy()
            val tmpExchange2 = exchange2.copy()
            etCurrencyObtained.text?.clear()
            setCurrencyValues(tmpExchange2, tmpExchange1)
        }

        btnCurrencyToObtain?.setOnLongClickListener {
            sendToExchangeRate(Constant.EXCHANGE_TYPE2)
        }

        btnBeginOperation.setOnClickListener {
            val ammount = etCurrencyToChange.text.toString().toDoubleOrNull() ?: 0.0
            val ammountObtained = ammount * exchange1.exchangeValue
            etCurrencyObtained.setText(ammountObtained.toString())

        }

        if (args?.currency1.orEmpty().trim().isNotEmpty() && args?.currency2.orEmpty().trim().isNotEmpty()) {
            viewModel.getExchange(args?.currency1.orEmpty(), args?.currency2.orEmpty())
        } else {
            viewModel.getExchange(Constant.ORIGIN_EXCHANGE, Constant.DEST_EXCHANGE)
        }
    }

    private fun sendToExchangeRate(dest: String): Boolean {
        val newArgs = ExchangeFragmentArgs(exchange1.exchangeCurrency, exchange2.exchangeCurrency, dest).toBundle()
        navigateTo(R.id.goToExchangeRate, newArgs)
        return true
    }

    private fun setupViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner, viewStateObserver)

    }

    private val viewStateObserver = Observer<ExchangeViewState> { state ->
        when (state) {
            is ExchangeViewState.Success -> setCurrencyValues(state.exchange1, state.exchange2)
            is ExchangeViewState.Failure -> toast(state.message)
        }
    }



    private fun setCurrencyValues(
        exchange1: ExchangeModel,
        exchange2: ExchangeModel
    ) {
        this.exchange1 = exchange1
        this.exchange2 = exchange2
        btnCurrencyToSend?.text = exchange1.description
        btnCurrencyToObtain?.text = exchange2.description
        exchangeInformation?.text = getString(
            R.string.exchange_information,
            exchange1.exchangeValue.toString(),
            exchange1.inchangeValue.toString()
        )
    }
}