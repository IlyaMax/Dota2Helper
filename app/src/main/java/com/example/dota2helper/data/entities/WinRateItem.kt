package com.example.dota2helper.data.entities

data class WinRateItem (
    val rank:Int,//1 -- Herald,2 -- Guardian,3 -- Crusader,4 -- Archon,5 -- Legend,6 -- Ancient,7 -- Divine,0 -- Pro
    val picked:Int,
    val won:Int,
    val banned:Int?
)