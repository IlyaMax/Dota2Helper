package com.example.dota2helper.data.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.dota2helper.data.entities.Hero
import io.reactivex.Completable

@Dao
interface HeroDao {

    @Query("SELECT * FROM hero")
    fun getHeroes(): LiveData<List<Hero>>

    @Query("SELECT * FROM hero WHERE hero.id = :id")
    fun getHeroById(id: Int): LiveData<Hero>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllHeroes(heroesList: List<Hero>): Completable
}