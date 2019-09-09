package com.example.dota2helper.data.retrofit

import com.example.dota2helper.data.entities.Hero
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface OpenDotaApiService {
    @GET("heroes")
    fun getHeroes(): Call<List<Hero>>

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