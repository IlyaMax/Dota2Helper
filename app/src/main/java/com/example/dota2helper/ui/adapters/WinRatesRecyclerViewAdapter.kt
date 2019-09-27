package com.example.dota2helper.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.dota2helper.R
import com.example.dota2helper.data.entities.WinRateItem
import java.lang.StringBuilder

class WinRatesRecyclerViewAdapter(private val context: Context) : BaseRecyclerViewAdapter<WinRateItem, BaseViewHolder<WinRateItem>>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<WinRateItem> {
        return WinRatesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_tv_with_drawable, parent, false))
    }

    inner class WinRatesViewHolder(itemView: View) : BaseViewHolder<WinRateItem>(itemView) {
        private val tvWinRates: TextView = itemView.findViewById(R.id.tvItemText)
        override fun onBind(item: WinRateItem) {
            val winRate = (((item.won.toDouble())/item.picked)*100).toInt()
            val bans = item.banned
            val strBuilder = StringBuilder("Процент побед: $winRate%")
            bans?.let{strBuilder.append("\nБаны: $it")}
            tvWinRates.text = strBuilder.toString()

            val drawableId = context.resources.getIdentifier("rank${item.rank}_icon","drawable",context.packageName)
            tvWinRates.setCompoundDrawablesRelativeWithIntrinsicBounds(context.getDrawable(drawableId),null,null,null)
        }
    }
}