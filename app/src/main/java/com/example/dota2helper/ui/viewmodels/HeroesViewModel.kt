package com.example.dota2helper.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dota2helper.data.repositories.HeroesRepository
import com.example.dota2helper.data.entities.Hero
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class HeroesViewModel : ViewModel() {
    //    private val heroesData: MutableLiveData<List<Hero.Entity>> = HeroesRepository.getHeroes()
//    fun getHeroesRepository():LiveData<List<Hero.Entity>> = heroesData
    private lateinit var heroesData: LiveData<List<Hero>>
    private val heroData = MutableLiveData<Hero>()
    val loading = MutableLiveData<Boolean>()

    fun getHeroes(): LiveData<List<Hero>> {
        heroesData = HeroesRepository.getHeroesFromDB()
        return heroesData
    }

    fun getHeroById(id: Int): LiveData<Hero> {
        HeroesRepository.getHeroById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                heroData.value = it
            },{
                it.printStackTrace()
            })
        return heroData
    }

    fun getHeroesFromAPIAndStore() {
        loading.value = true
        HeroesRepository.getHeroesFromApi()
            .subscribeOn(Schedulers.io())
            .subscribe({
                HeroesRepository.saveHeroesToDb(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { loading.value = false }
            }, {
                it.printStackTrace()
            }
            )

    }
}