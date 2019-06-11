package com.example.aoeunits.presenter
import com.example.aoeunits.model.AoEDataReciver
import com.example.aoeunits.model.AoEUnitValue
import com.example.aoeunits.view.MainActivityView
import com.example.aoeunits.view.MainActivity
import dagger.Component
import javax.inject.Inject

class MainActivityPresenter(private var mainActivityView: MainActivityView?, var dataReciver: AoEDataReciver) {

    fun getData():ArrayList<AoEUnitValue>?  {

            val listOfUnits =  dataReciver.getUnits()
            return listOfUnits

        }

    }
