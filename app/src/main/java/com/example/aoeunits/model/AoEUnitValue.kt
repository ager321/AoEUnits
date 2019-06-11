package com.example.aoeunits.model

//data class AoEUnitValue (
//    var id : Int,
//    var name : String,
//    val description : String)

data class AoEUnitValue (
    val id: Long,
    val name: String,
    val description: String,
    val createdIn: String,
    val buildTime: Long? = null,
    val reloadTime: Double? = null,
    val attackDelay: Double? = null,
    val movementRate: Double? = null,
    val lineOfSight: Long,
    val hitPoints: Long,
    val attack: Long? = null,
    val armor: String,
    val accuracy: String? = null,
    val searchRadius: Long? = null,
    val armorBonus: List<String>? = null
)