package com.retobcp.features.exchange_rate

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.retobcp.R
import com.retobcp.features.base.BaseFragment
import com.retobcp.features.exchange.ExchangeFragmentArgs
import com.retobcp.features.exchange_rate.adapter.ExchangeRateAdapter
import com.retobcp.features.model.ExchangeModel
import com.retobcp.features.utils.Constant
import com.retobcp.features.utils.navigateTo
import com.retobcp.features.utils.toast
import kotlinx.android.synthetic.main.fragment_exchange_rate.*
import org.koin.android.viewmodel.ext.android.viewModel

class ExchangeRateFragment : BaseFragment() {

    private val args get() = arguments?.let { ExchangeFragmentArgs.fromBundle(it) }

    private val viewModel by viewModel<ExchangeRateViewModel>()

    private val linearLayoutManager get() = LinearLayoutManager(context)

    private val exchangeRateAdapter by lazy {
        val currencyModel = getCurrency()
        ExchangeRateAdapter(currencyModel.first) { item ->
            onItemClick(item)
        }
    }

    override fun getLayoutId() = R.layout.fragment_exchange_rate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        rvExchangeRate?.apply {
            layoutManager = linearLayoutManager
            itemAnimator = DefaultItemAnimator()
            isNestedScrollingEnabled = false
            adapter = exchangeRateAdapter
        }

    }

    private fun setupViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner, viewStateObserver)
        val currencyModel = getCurrency()
        viewModel.getExchange(currencyModel.first, currencyModel.second)
    }

    private val viewStateObserver = Observer<ExchangeRateViewState> { state ->
        when (state) {
            is ExchangeRateViewState.Success -> setupList(state.items)
            is ExchangeRateViewState.Failure -> toast(state.message)
        }
    }

    private fun setupList(items: List<ExchangeModel>) {
        exchangeRateAdapter.addData(items)
    }

    private fun getCurrency(): Pair<String, String> {
        return if (args?.dest == Constant.EXCHANGE_TYPE1) {
            Pair(args?.currency1.orEmpty(), args?.currency2.orEmpty())
        } else {
            Pair(args?.currency2.orEmpty(), args?.currency1.orEmpty())
        }
    }

    private fun onItemClick(item: ExchangeModel) {
        val models = if (args?.dest == Constant.EXCHANGE_TYPE1) {
            Pair(item.exchangeCurrency, args?.currency2.orEmpty())
        } else {
            Pair(args?.currency1.orEmpty(), item.exchangeCurrency)
        }
        val newArgs =
            ExchangeFragmentArgs(models.first, models.second, args?.dest.orEmpty()).toBundle()
        navigateTo(R.id.returnToExchange, newArgs)
    }
}