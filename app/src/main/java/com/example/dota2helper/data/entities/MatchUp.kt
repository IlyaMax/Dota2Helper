package com.example.dota2helper.data.entities

import com.google.gson.annotations.SerializedName

data class MatchUp (
    @SerializedName("hero_id") val heroId:Int,
    @SerializedName("games_played") val gamesPlayed:Int,
    @SerializedName("wins") val wins:Int
)