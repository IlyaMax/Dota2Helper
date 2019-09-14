package com.example.dota2helper.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "hero")
data class Hero(
    @PrimaryKey @SerializedName("id") @Expose val id: Int,
    @SerializedName("name") @Expose val name: String,
    @SerializedName("localized_name") @Expose val localizedName: String,
    @SerializedName("primary_attr") @Expose val attribute: String
)