package com.example.dota2helper.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dota2helper.data.entities.Hero

@Database(entities = [(Hero::class)], version = 2)
abstract class Dota2Database : RoomDatabase() {

    abstract fun heroDao(): HeroDao
}
