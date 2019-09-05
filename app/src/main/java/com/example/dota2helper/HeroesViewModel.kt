package com.example.dota2helper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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
        mutableLiveData = heroesRepository!!.getHeroes()

    }

    fun getHeroesRepository(): LiveData<List<Hero.Entity>>? {
        return mutableLiveData
    }
}