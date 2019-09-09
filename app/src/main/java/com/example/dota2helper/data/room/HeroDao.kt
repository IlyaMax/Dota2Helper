package com.example.dota2helper.data.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.dota2helper.data.entities.Hero

@Dao
interface HeroDao {

    @Query("SELECT * FROM hero WHERE hero.attribute=:attribute")
    fun getHeroesByAttribute(attribute:String) : LiveData<List<Hero>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllHeroes(heroesList: List<Hero>)
}