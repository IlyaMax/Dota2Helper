package com.example.dota2helper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment

class AttributeHeroesFragment : Fragment() {
    private var gridView: GridView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.attribute_heroes_fragment, container, false)
        gridView = view.findViewById(R.id.gridView)
        gridView!!.adapter = HeroGridAdapter(context)
        return view
    }
}