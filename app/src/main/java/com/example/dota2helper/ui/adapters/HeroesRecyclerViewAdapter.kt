package com.example.dota2helper.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.example.dota2helper.R
import com.example.dota2helper.data.entities.Hero
import com.example.dota2helper.getHeroImgUrl
import com.example.dota2helper.ui.views.activities.HeroActivity
import com.squareup.picasso.Picasso


class HeroesRecyclerViewAdapter(var heroesList: List<Hero>) :
    RecyclerView.Adapter<HeroesRecyclerViewAdapter.HeroesViewHolder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false)
        return HeroesViewHolder(itemView)
    }

    override fun getItemCount(): Int = heroesList.size

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        //Log.d("DEBUG",String.format("http://cdn.dota2.com/apps/dota2/images/heroes/%s_%s",heroesList.get(position).name.removePrefix("npc_dota_hero_"),size))
        holder.ivHero.setOnClickListener {
            val intent = Intent(context, HeroActivity::class.java)
            intent.putExtra("hero_id", heroesList[position].id)
            context.startActivity(intent)
        }
        Picasso.get()
            .load(
                getHeroImgUrl(heroesList[position].name, "lg.png")
            )
            .into(holder.ivHero)
    }

    class HeroesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivHero: ImageView = itemView.findViewById(R.id.ivHero)
    }

}