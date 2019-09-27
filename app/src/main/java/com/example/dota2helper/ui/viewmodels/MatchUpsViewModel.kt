package com.example.dota2helper.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dota2helper.data.entities.Hero
import com.example.dota2helper.data.entities.MatchUp
import com.example.dota2helper.data.repositories.HeroesRepository
import com.example.dota2helper.data.repositories.MatchUpsRepository
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MatchUpsViewModel : ViewModel() {
    private val counterPicks = MutableLiveData<List<Hero>>()
    private val pickAgainst = MutableLiveData<List<Hero>>()

    fun getCounterPicks(heroId: Int): MutableLiveData<List<Hero>> {

        val heroesList = mutableListOf<Hero>()
        MatchUpsRepository.getSortedMatchUps(heroId)
            .map {
                it.take(5)
            }
            .flatMap{
                Observable.fromIterable(it)
            }
            .flatMap{
                HeroesRepository.getHeroById(it.heroId)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                heroesList.add(it)
                counterPicks.value = heroesList
            }, {
                Log.d("myTag", it.message)
            })
        return counterPicks
    }

    fun getPickAgainst(heroId: Int): MutableLiveData<List<Hero>> {
        val heroesList = mutableListOf<Hero>()
        MatchUpsRepository.getSortedMatchUps(heroId)
            .map {
                it.takeLast(5)
            }
            .flatMap{
                Observable.fromIterable(it)
            }
            .flatMap{
                HeroesRepository.getHeroById(it.heroId)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                heroesList.add(it)
                pickAgainst.value = heroesList
            }, {
                Log.d("myTag", it.message)
            })
        return pickAgainst
    }

}