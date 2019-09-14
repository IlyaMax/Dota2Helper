package com.example.dota2helper.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dota2helper.data.repositories.HeroesRepository
import com.example.dota2helper.data.entities.Hero

class HeroesViewModel : ViewModel() {
    //    private val heroesData: MutableLiveData<List<Hero.Entity>> = HeroesRepository.getHeroes()
//    fun getHeroesRepository():LiveData<List<Hero.Entity>> = heroesData
    private lateinit var heroesData: LiveData<List<Hero>>

    fun getHeroesFromDBByAttribute(attribute: String): LiveData<List<Hero>> {
        heroesData = HeroesRepository.getHeroesFromDBByAttribute(attribute)
        return heroesData
    }

    fun getHeroesFromAPIAndStore() {
        HeroesRepository.getHeroesFromAPIAndStore()
    }
}