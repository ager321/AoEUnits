package com.example.aoeunits.model

import com.google.gson.annotations.SerializedName

data class AoEUnitValue (

    @SerializedName("id") val id : Long,
    @SerializedName("name") val name : String,
    @SerializedName("description") val description : String,
    @SerializedName("expansion") val expansion : String,
    @SerializedName("age") val age : String,
    @SerializedName("created_in") val created_in : String,
    @SerializedName("build_time") val build_time : Int,
    @SerializedName("reload_time") val reload_time : Double?,
    @SerializedName("movement_rate") val movement_rate : Double,
    @SerializedName("line_of_sight") val line_of_sight : Long,
    @SerializedName("hit_points") val hit_points : Long,
    @SerializedName("attack") val attack : Int,
    @SerializedName("armor") val armor : String

)