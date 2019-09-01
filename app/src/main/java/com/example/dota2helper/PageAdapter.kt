package com.example.dota2helper

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager?, val numOfTabs: Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return AttributeHeroesFragment();
    }

    override fun getCount(): Int {
        return numOfTabs
    }
}