package com.example.dota2helper.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.dota2helper.R
import com.example.dota2helper.data.entities.Hero
import com.example.dota2helper.getHeroImgUrl
import com.example.dota2helper.ui.views.activities.HeroActivity
import com.squareup.picasso.Picasso


class HeroesRecyclerViewAdapter(private val context: Context,private val clickableItems:Boolean) :
    BaseRecyclerViewAdapter<Hero, BaseViewHolder<Hero>>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Hero> {
        return HeroesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false))
    }

    inner class HeroesViewHolder(itemView: View) : BaseViewHolder<Hero>(itemView) {
        private val ivHero: ImageView = itemView.findViewById(R.id.ivHero)
        override fun onBind(item: Hero) {
            if (clickableItems) ivHero.setOnClickListener {
                val intent = Intent(this@HeroesRecyclerViewAdapter.context, HeroActivity::class.java)
                intent.putExtra("hero_id", item.id)
                context.startActivity(intent)
            }
            Picasso.get()
                .load(
                    getHeroImgUrl(item.name, "lg.png")
                )
                .into(ivHero)
        }
    }

}