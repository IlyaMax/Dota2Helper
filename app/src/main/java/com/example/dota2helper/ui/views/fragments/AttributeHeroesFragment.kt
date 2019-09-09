package com.example.dota2helper.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2helper.ui.adapters.HeroesRecyclerViewAdapter
import com.example.dota2helper.ui.viewmodels.HeroesViewModel
import com.example.dota2helper.R




class AttributeHeroesFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var heroesViewModel: HeroesViewModel? = null

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
        val view = inflater.inflate(R.layout.attribute_heroes_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        val layoutManager = GridLayoutManager(context,3)
        recyclerView!!.layoutManager = layoutManager
        heroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
        heroesViewModel!!.init()
        heroesViewModel!!.getHeroesRepository()!!.observe(this, Observer {
//            Log.d("DEBUG",attribute)
//            Log.d("DEBUG",it.toString())
            recyclerView!!.adapter =
                HeroesRecyclerViewAdapter(it.filter { hero -> hero.attribute == arguments!!.getString("attribute") })
            recyclerView!!.adapter!!.notifyDataSetChanged()

        })
        return view
    }
}