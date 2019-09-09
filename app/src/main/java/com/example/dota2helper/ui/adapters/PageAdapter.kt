package com.example.dota2helper.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.dota2helper.ui.views.fragments.AttributeHeroesFragment

class PageAdapter(fm: FragmentManager?, val numOfTabs: Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0->AttributeHeroesFragment.newInstance("str")
            1->AttributeHeroesFragment.newInstance("agi")
            2->AttributeHeroesFragment.newInstance("int")
            else->null!!
        }
    }

    override fun getCount(): Int {
        return numOfTabs
    }
}