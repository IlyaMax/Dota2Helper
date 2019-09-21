package com.example.dota2helper.ui.adapters

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.dota2helper.R
import com.example.dota2helper.data.entities.Hero
import com.example.dota2helper.getHeroImgUrl
import com.example.dota2helper.ui.views.activities.HeroActivity
import com.squareup.picasso.Picasso

class RolesRecyclerViewAdapter(private val context: Context) : BaseRecyclerViewAdapter<String, BaseViewHolder<String>>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        return RolesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_role, parent, false))
    }

    inner class RolesViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {
        private val tvRole: TextView = itemView.findViewById(R.id.tvRole)
        override fun onBind(item: String) {
            tvRole.text = item
            val drawableId = context.resources.getIdentifier(tvRole.text.toString().toLowerCase() + "_icon","drawable",context.packageName)
            tvRole.setCompoundDrawablesRelativeWithIntrinsicBounds(context.getDrawable(drawableId),null,null,null)
        }
    }
}