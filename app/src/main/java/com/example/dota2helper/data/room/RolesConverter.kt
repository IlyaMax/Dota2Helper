package com.example.dota2helper.data.room

import androidx.room.TypeConverter
import java.util.stream.Collectors

class RolesConverter {
    @TypeConverter
    fun fromRoles(roles: List<String>): String {
        return roles.stream().collect(Collectors.joining(","))
    }

    @TypeConverter
    fun toRoles(roles: String): List<String> {
        return roles.split(",")
    }
}