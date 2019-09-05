package com.example.dota2helper

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager?, val numOfTabs: Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0->AttributeHeroesFragment("str")
            1->AttributeHeroesFragment("agi")
            2->AttributeHeroesFragment("int")
            else->null!!
        }
    }

    override fun getCount(): Int {
        return numOfTabs
    }
}