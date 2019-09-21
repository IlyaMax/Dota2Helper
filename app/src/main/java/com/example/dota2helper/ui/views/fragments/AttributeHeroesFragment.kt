package com.example.dota2helper.ui.views.fragments

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2helper.ui.adapters.HeroesRecyclerViewAdapter
import com.example.dota2helper.ui.viewmodels.HeroesViewModel
import com.example.dota2helper.R
import com.example.dota2helper.common.NetworkState
import com.example.dota2helper.data.entities.Hero
import kotlinx.android.synthetic.main.attribute_heroes_fragment.*


class AttributeHeroesFragment : Fragment() {


    private lateinit var heroesViewModel: HeroesViewModel
    private var heroesList: List<Hero>? = null
    private lateinit var adapter:HeroesRecyclerViewAdapter

    companion object {
        fun newInstance(attribute: String): AttributeHeroesFragment {
            val args = Bundle()
            args.putString("attribute", attribute)
            val f = AttributeHeroesFragment()
            f.arguments = args
            return f
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.attribute_heroes_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        adapter = HeroesRecyclerViewAdapter(context!!)
        recyclerView.adapter = adapter

        if (heroesList == null) {
            heroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
            heroesViewModel.getHeroes().observe(this, Observer {
                Log.d("myTag", it.toString())
                heroesList = it.filter { hero -> hero.attribute == arguments?.getString("attribute")!! }
                adapter.setItems(heroesList)
            })
        } else {
            adapter.setItems(heroesList)
        }

    }

}