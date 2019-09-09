package com.example.dota2helper.data.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dota2helper.core.retrofit.OpenDotaApiService
import com.example.dota2helper.data.entities.Hero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object HeroesRepository{
    private val apiService = OpenDotaApiService.create()
    fun getHeroes(): MutableLiveData<List<Hero.Entity>> {
        val heroesData = MutableLiveData<List<Hero.Entity>>()
        apiService.getHeroes().enqueue(object : Callback<List<Hero.Entity>>{
            override fun onFailure(call: Call<List<Hero.Entity>>, t: Throwable) {
                Log.d("DEBUG","Failed")
                heroesData.value = null
            }

            override fun onResponse(call: Call<List<Hero.Entity>>, response: Response<List<Hero.Entity>>) {
                if (response.isSuccessful) {
                    //Log.d("DEBUG",response.body().toString())
                    heroesData.value = response.body()
                }
            }

        })
        return heroesData
    }
}