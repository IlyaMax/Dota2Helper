package com.example.dota2helper.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

interface Hero {
    data class Entity(
        @SerializedName("id") @Expose val id: Int,
        @SerializedName("name") @Expose val name: String,
        @SerializedName("localized_name") @Expose val localizedName: String,
        @SerializedName("primary_attr") @Expose val attribute: String
    )

}