package com.example.dota2helper

//see HEROES section to understand the way I get images https://dev.dota2.com/showthread.php?t=58317
fun getHeroImgUrl(name: String, size: String): String {
    return String.format(
        "http://cdn.dota2.com/apps/dota2/images/heroes/%s_%s",
        name.removePrefix("npc_dota_hero_"),
        size
    )
}