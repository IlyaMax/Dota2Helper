package com.example.dota2helper.common

import android.app.Application
import androidx.room.Room
import com.example.dota2helper.data.room.Dota2Database

class App : Application() {

    companion object {
        lateinit var database: Dota2Database
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(applicationContext, Dota2Database::class.java, "heroes_db").fallbackToDestructiveMigration().build()
    }
}