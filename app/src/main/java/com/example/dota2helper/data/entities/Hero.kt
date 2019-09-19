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
    @SerializedName("primary_attr") @Expose val attribute: String,
    @SerializedName("attack_type") @Expose val attackType: String,
    @SerializedName("roles") @Expose val roles: List<String>,
    @SerializedName("pro_win") val proWin : Int,
    @SerializedName("pro_pick") val proPick : Int,
    @SerializedName("pro_ban") val proBan : Int,
    //1 -- Herald,2 -- Guardian,3 -- Crusader,4 -- Archon,5 -- Legend,6 -- Ancient,7 -- Divine
    @SerializedName("1_pick") val pick1: Int,
    @SerializedName("1_win") val win1 : Int,
    @SerializedName("2_pick") val pick2 : Int,
    @SerializedName("2_win") val win2 : Int,
    @SerializedName("3_pick") val pick3 : Int,
    @SerializedName("3_win") val win3 : Int,
    @SerializedName("4_pick") val pick4 : Int,
    @SerializedName("4_win") val win4 : Int,
    @SerializedName("5_pick") val pick5 : Int,
    @SerializedName("5_win") val win5 : Int,
    @SerializedName("6_pick") val pick6 : Int,
    @SerializedName("6_win") val win6 : Int,
    @SerializedName("7_pick") val pick7 : Int,
    @SerializedName("7_win") val win7 : Int
    )