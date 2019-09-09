package com.example.dota2helper.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.dota2helper.ui.adapters.PageAdapter
import com.example.dota2helper.R
import com.example.dota2helper.common.NetworkState
import com.example.dota2helper.ui.viewmodels.HeroesViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.heroes_fragment.*


class HeroesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.heroes_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!NetworkState.isNetworkConnected(context!!))
        {
            Toast.makeText(context,"No internet found. Showing cached list in the view", Toast.LENGTH_LONG).show()
        }
        viewPager!!.adapter = PageAdapter(fragmentManager, tabs!!.tabCount)
        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}