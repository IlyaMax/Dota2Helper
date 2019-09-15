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
    var loading = MutableLiveData<Boolean>()

    fun getHeroesFromDBByAttribute(attribute: String): LiveData<List<Hero>> {
        heroesData = HeroesRepository.getHeroesFromDBByAttribute(attribute)
        return heroesData
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
                },{
                    it.printStackTrace()
                }
            )

    }
}