package com.example.dota2helper.data.repositories

import com.example.dota2helper.data.entities.Hero
import com.example.dota2helper.data.entities.MatchUp
import com.example.dota2helper.data.retrofit.OpenDotaApiService
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import kotlin.Comparator

object MatchUpsRepository {
    private val apiService = OpenDotaApiService.create()
    fun getSortedMatchUps(heroId: Int): Observable<List<MatchUp>> {
        return apiService.getMatchUps(heroId)
            .subscribeOn(Schedulers.io())
            .map{
                it.sortedWith(Comparator { item1, item2 ->
                    ((item2.wins.toDouble()) / item2.gamesPlayed).compareTo((item2.wins.toDouble()) / item1.gamesPlayed)
                })
            }
//                    .map { matchUp ->
//                        Log.d("myTag", matchUp.toString())
//                        HeroesRepository.getHeroById(matchUp.heroId)
//                            .subscribeOn(Schedulers.io())
//                            .subscribe({ hero ->
//                                run {
//                                    heroesList.add(hero)
//                                    Log.d("myTag", hero.toString())
//                                }
//                            }, { throwable -> throwable.printStackTrace() })
//                    }
//                Log.d("myTag", heroesList.toString())
//                heroesList as List<Hero>
//            }
    }
}