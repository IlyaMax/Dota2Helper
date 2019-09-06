package com.example.dota2helper

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL


class AttributeHeroesFragment(private val attribute:String) : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var heroesViewModel:HeroesViewModel? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.attribute_heroes_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        val layoutManager = GridLayoutManager(context,3)
        recyclerView!!.layoutManager = layoutManager
        heroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
        heroesViewModel!!.init()
        heroesViewModel!!.getHeroesRepository()!!.observe(this, Observer {
//            Log.d("DEBUG",attribute)
//            Log.d("DEBUG",it.toString())
            recyclerView!!.adapter = HeroesRecyclerViewAdapter(it.filter { hero -> hero.attribute == attribute})
            recyclerView!!.adapter!!.notifyDataSetChanged()

        })
        return view
    }
}