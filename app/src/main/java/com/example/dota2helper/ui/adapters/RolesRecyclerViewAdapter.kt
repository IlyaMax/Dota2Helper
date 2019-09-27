package com.example.dota2helper.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.dota2helper.R

class RolesRecyclerViewAdapter(private val context: Context) : BaseRecyclerViewAdapter<String, BaseViewHolder<String>>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        return RolesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_tv_with_drawable, parent, false))
    }

    inner class RolesViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {
        private val tvRole: TextView = itemView.findViewById(R.id.tvItemText)
        override fun onBind(item: String) {
            tvRole.text = item
            val drawableId = context.resources.getIdentifier("${item.toLowerCase()}_icon","drawable",context.packageName)
            tvRole.setCompoundDrawablesRelativeWithIntrinsicBounds(context.getDrawable(drawableId),null,null,null)
        }
    }
}