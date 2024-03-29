package com.example.dota2helper.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dota2helper.common.App
import com.example.dota2helper.data.retrofit.OpenDotaApiService
import com.example.dota2helper.data.entities.Hero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.os.Handler
import io.reactivex.Completable
import io.reactivex.Completable.fromCallable
import io.reactivex.Observable
import io.reactivex.Single


object HeroesRepository {
    private val apiService = OpenDotaApiService.create()
    fun getHeroesFromDB(): LiveData<List<Hero>> {
        return App.database.heroDao().getHeroes()
    }

    fun getHeroesFromApi(): Single<List<Hero>> {
        return apiService.getHeroes()
    }

    fun saveHeroesToDb(heroes: List<Hero>?): Completable {
        return App.database.heroDao().insertAllHeroes(heroes!!)
    }

    fun getHeroById(id: Int): Observable<Hero> {
        return App.database.heroDao().getHeroById(id)
    }
}