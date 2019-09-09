package com.example.dota2helper.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dota2helper.data.repositories.HeroesRepository
import com.example.dota2helper.data.entities.Hero

class HeroesViewModel : ViewModel() {
//    private val heroesData: MutableLiveData<List<Hero.Entity>> = HeroesRepository.getHeroes()
//    fun getHeroesRepository():LiveData<List<Hero.Entity>> = heroesData
    private var mutableLiveData: MutableLiveData<List<Hero.Entity>>? = null
    private var heroesRepository: HeroesRepository? = null

    fun init() {
        if (mutableLiveData != null) {
            return
        }
        heroesRepository = HeroesRepository
        mutableLiveData = HeroesRepository.getHeroes()

    }

    fun getHeroesRepository(): LiveData<List<Hero.Entity>>? {
        return mutableLiveData
    }
}