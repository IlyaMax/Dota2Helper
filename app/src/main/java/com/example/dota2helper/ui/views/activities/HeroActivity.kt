package com.example.dota2helper.ui.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dota2helper.R
import com.example.dota2helper.data.entities.Hero
import com.example.dota2helper.data.entities.MatchUp
import com.example.dota2helper.data.entities.WinRateItem
import com.example.dota2helper.getHeroImgUrl
import com.example.dota2helper.ui.adapters.*
import com.example.dota2helper.ui.viewmodels.HeroesViewModel
import com.example.dota2helper.ui.viewmodels.MatchUpsViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_hero.*
import kotlinx.android.synthetic.main.attribute_heroes_fragment.view.*
import java.lang.reflect.Field

class HeroActivity : AppCompatActivity() {

    private lateinit var heroesViewModel: HeroesViewModel
    private lateinit var matchUpsViewModel: MatchUpsViewModel
    private val heroId by lazy { intent.extras?.get("hero_id") as Int }
    private lateinit var rolesAdapter: BaseRecyclerViewAdapter<String, BaseViewHolder<String>>
    private lateinit var winRatesAdapter: BaseRecyclerViewAdapter<WinRateItem, BaseViewHolder<WinRateItem>>
    private lateinit var counterPicksAdapter: BaseRecyclerViewAdapter<Hero, BaseViewHolder<Hero>>
    private lateinit var pickAgainstAdapter: BaseRecyclerViewAdapter<Hero, BaseViewHolder<Hero>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero)
        heroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
        matchUpsViewModel = ViewModelProviders.of(this).get(MatchUpsViewModel::class.java)
        Log.d("myDebug", heroId.toString())
        initViews()
        //TODO: заполнить rvWinRates
        heroesViewModel.getHeroById(heroId).observe(this, Observer {
            Picasso.get().load(getHeroImgUrl(it.name, "lg.png")).into(ivHero)
            rolesAdapter.setItems(it.roles)


            val winRateItems = mutableListOf<WinRateItem>()
            for (i in (1..7)) {
                val pickField: Field = it.javaClass.getDeclaredField("pick$i")
                pickField.isAccessible = true
                val pickValue = pickField.getInt(it)
                val winField: Field = it.javaClass.getDeclaredField("win$i")
                winField.isAccessible = true
                val winValue = winField.getInt(it)
                winRateItems.add(WinRateItem(i, pickValue, winValue, null))
            }
            winRateItems.add(WinRateItem(0, it.proPick, it.proWin, it.proBan))
            winRatesAdapter.setItems(winRateItems)
        })
        matchUpsViewModel.getCounterPicks(heroId).observe(this,Observer{
            Log.d("myTag",it.toString())
            counterPicksAdapter.setItems(it)
        })
        matchUpsViewModel.getPickAgainst(heroId).observe(this,Observer{
            Log.d("myTag",it.toString())
            pickAgainstAdapter.setItems(it)
        })
    }

    private fun initViews() {
        rolesAdapter = RolesRecyclerViewAdapter(this)
        winRatesAdapter = WinRatesRecyclerViewAdapter(this)
        counterPicksAdapter = HeroesRecyclerViewAdapter(this, false)
        pickAgainstAdapter = HeroesRecyclerViewAdapter(this, false)
        rvRoles.layoutManager = LinearLayoutManager(this)
        rvRoles.adapter = rolesAdapter
        rvWinRates.layoutManager = LinearLayoutManager(this)
        rvWinRates.adapter = winRatesAdapter
        rvCounterPicks.layoutManager = GridLayoutManager(this, 5)
        rvCounterPicks.adapter = counterPicksAdapter
        rvPickAgainst.layoutManager = GridLayoutManager(this, 5)
        rvPickAgainst.adapter = pickAgainstAdapter
    }
}
