package com.retobcp.features.exchange_rate.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.retobcp.R
import com.retobcp.features.model.ExchangeModel
import com.retobcp.features.utils.inflate
import kotlinx.android.synthetic.main.item_exchange_rate.view.*

class ExchangeRateAdapter(
    private val exchangeValue: String,
    private val onClick: (ExchangeModel) -> Unit
) : RecyclerView.Adapter<ExchangeRateAdapter.ExchangeRateViewHolder>() {

    private val items = arrayListOf<ExchangeModel>()

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeRateViewHolder {
        val view = parent.inflate(R.layout.item_exchange_rate)
        return ExchangeRateViewHolder(view, exchangeValue, onClick)
    }

    override fun onBindViewHolder(holder: ExchangeRateViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun addData(items: List<ExchangeModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class ExchangeRateViewHolder(
        v: View,
        private val exchangeValue: String,
        private val onItemClick: (ExchangeModel) -> Unit
    ) : RecyclerView.ViewHolder(v) {
        fun bind(item: ExchangeModel) = with(itemView) {
            tvCountryName?.text = item.countryName
            tvCountryCurrency?.text = getCurrency(context, item, exchangeValue)
            ivCountry?.setImageResource(getFlag(item.exchangeCurrency))
            setOnClickListener { onItemClick(item) }
        }

        private fun getCurrency(context: Context, item: ExchangeModel, exchangeValue: String) =
            context.getString(
                R.string.exchange_rate_currency,
                exchangeValue,
                item.exchangeValue.toString(),
                item.exchangeCurrency
            )

        private fun getFlag(currency:String): Int {
            return when(currency){
                "PEN" -> R.drawable.ic_peru
                "EUR" -> R.drawable.ic_europe
                "USD" -> R.drawable.ic_usa
                "YEN" -> R.drawable.ic_china
                else -> R.drawable.ic_flag
            }
        }

    }
}