package com.example.aoeunits.view

import com.example.aoeunits.model.AoEUnitValue

interface MainActivityView {

    fun setDescription(Description: String)
    fun setAttackValue(AttackValue: String)
    fun setReloadTime(ReloadTime: String)
    fun setDPS(DPS: String)
    fun setHitPoints(HitPoints: String)
    fun setLineOfSight(LineOfSight: String)

}