package com.example.dota2helper

//see HEROES section to understand the way I get images https://dev.dota2.com/showthread.php?t=58317
fun getHeroImgUrl(name: String, size: String): String {
    return "http://cdn.dota2.com/apps/dota2/images/heroes/${name.removePrefix("npc_dota_hero_")}_$size"
}