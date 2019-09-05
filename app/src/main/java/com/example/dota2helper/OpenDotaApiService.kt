package com.example.dota2helper

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface OpenDotaApiService {
    @GET("heroes")
    fun getHeroes(): Call<List<Hero.Entity>>

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