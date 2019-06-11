package com.example.aoeunits.presenter

import com.example.aoeunits.model.AoEDataReciver
import com.example.aoeunits.model.AoEUnitValue
import com.example.aoeunits.view.MainActivityView
import com.example.aoeunits.view.UnitsListView

class UnitsListPresenter(private var unitsListView: UnitsListView?, var dataReciver: AoEDataReciver) {

    fun getData(): ArrayList<AoEUnitValue>? {

        val listOfUnits = dataReciver.getUnits()
        return listOfUnits

    }
}