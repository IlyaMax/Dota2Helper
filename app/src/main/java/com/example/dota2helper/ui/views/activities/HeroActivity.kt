package com.example.dota2helper.ui.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.dota2helper.R
import com.example.dota2helper.getHeroImgUrl
import com.example.dota2helper.ui.viewmodels.HeroesViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_hero.*

class HeroActivity : AppCompatActivity() {

    private lateinit var heroesViewModel: HeroesViewModel
    private val heroId by lazy { intent.extras?.get("hero_id") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero)
        heroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
        Log.d("myDebug", heroId.toString())

        //TODO: заполнить lvRoles, rvWinRates
        heroesViewModel.getHeroById(heroId as Int).observe(this, Observer {
            Picasso.get().load(getHeroImgUrl(it.name, "lg.png")).into(ivHero)
        })
        //TODO: заполнить rvCounterPicks
//        heroesViewModel.getCounterPicks(heroId,5){
//
//        }
        //TODO: заполнить rvPickAgainst
//        heroesViewModel.getCounterPicks(heroId,5){
//
//        }
    }
}
