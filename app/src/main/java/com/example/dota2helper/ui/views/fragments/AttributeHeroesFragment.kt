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
import kotlinx.android.synthetic.main.attribute_heroes_fragment.*


class AttributeHeroesFragment : Fragment() {


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
        return inflater.inflate(R.layout.attribute_heroes_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = GridLayoutManager(context,3)
        heroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
        heroesViewModel!!.heroesData.observe(this, Observer {
            //            Log.d("DEBUG",attribute)
//            Log.d("DEBUG",it.toString())
            progressBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
            recyclerView.adapter =
                HeroesRecyclerViewAdapter(it.filter { hero -> hero.attribute == arguments!!.getString("attribute") })
            recyclerView.adapter!!.notifyDataSetChanged()

        })
    }
}