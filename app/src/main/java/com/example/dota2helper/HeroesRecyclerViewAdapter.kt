package com.example.dota2helper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.item_hero.view.*
import android.text.method.TextKeyListener.clear
import android.util.Log
import com.squareup.picasso.Picasso


class HeroesRecyclerViewAdapter(var heroesList: List<Hero.Entity>) : RecyclerView.Adapter<HeroesRecyclerViewAdapter.HeroesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return HeroesViewHolder(itemView)
    }

    override fun getItemCount(): Int = heroesList.size

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        //see HEROES section to understand the way I get images https://dev.dota2.com/showthread.php?t=58317
        val size = "lg.png"
        //Log.d("DEBUG",String.format("http://cdn.dota2.com/apps/dota2/images/heroes/%s_%s",heroesList.get(position).name.removePrefix("npc_dota_hero_"),size))

        Picasso.get()
            .load(String.format("http://cdn.dota2.com/apps/dota2/images/heroes/%s_%s",heroesList.get(position).name.removePrefix("npc_dota_hero_"),size))
            .into(holder.ivHero)
    }

    class HeroesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivHero: ImageView = itemView.findViewById(R.id.ivHero)
    }

}