package com.example.dota2helper.data.retrofit

import androidx.lifecycle.LiveData
import com.example.dota2helper.data.entities.Hero
import com.example.dota2helper.data.entities.MatchUp
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenDotaApiService {
    @GET("heroStats")
    fun getHeroes(): Single<List<Hero>>
    @GET("heroes/{hero_id}/matchups")
    fun getMatchUps(@Path("hero_id") heroId:Int): Observable<List<MatchUp>>

    companion object Factory {
        fun create(): OpenDotaApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.opendota.com/api/")
                .build()
            return retrofit.create(OpenDotaApiService::class.java)
        }
    }
}