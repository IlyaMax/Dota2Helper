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


object HeroesRepository{
    private val apiService = OpenDotaApiService.create()
    fun getHeroesFromDBByAttribute(attribute:String): LiveData<List<Hero>> {
        return App.database.heroDao().getHeroesByAttribute(attribute)
    }

    fun getHeroesFromAPIAndStore() {
        apiService.getHeroes().enqueue(object : Callback<List<Hero>>{
            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                Log.d("DEBUG","Failed to get heroes")
            }

            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                if (response.isSuccessful) {
                    //Log.d("DEBUG",response.body().toString())
                    Thread(Runnable {
                        App.database.heroDao().insertAllHeroes(response.body()!!)
                    }).start()

                }
            }

        })
    }
}