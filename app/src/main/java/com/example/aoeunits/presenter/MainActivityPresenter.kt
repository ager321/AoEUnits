package com.example.aoeunits.presenter
import com.example.aoeunits.model.AoEDataReciver
import com.example.aoeunits.model.AoEUnitValue
import com.example.aoeunits.view.MainActivityView
import com.example.aoeunits.view.MainActivity
import dagger.Component
import javax.inject.Inject

class MainActivityPresenter(private var mainActivityView: MainActivityView?, var dataReciver: AoEDataReciver) {

    private fun getData(name: String):AoEUnitValue?  {

            val unit =  dataReciver.getUnit(name)
            return unit

        }

    private fun calculateDPS(attack: Int?, reload: Double?): Double
    {
        if (attack == null || reload == null)
            return 0.0

        return attack/reload
    }


    private fun calculatelineOfSight(lineOfSight: Long?): String
    {
        if (lineOfSight == null)
            return "None"
        if (lineOfSight < 2)
            return "Small"
        if (lineOfSight  <5)
            return "Medium"
        if (lineOfSight < 10)
            return "Big"

        return "Huge"

    }


    fun setData(name: String){

        val unit =  getData(name)

        if(unit == null)
        {
            mainActivityView?.setDescription("Not found")
        }
        else
        {
            mainActivityView?.setDescription(unit.description)
            mainActivityView?.setAttackValue(unit.attack.toString())
            mainActivityView?.setReloadTime(unit.reload_time.toString())

            val dps = calculateDPS(unit.attack, unit.reload_time)
            mainActivityView?.setDPS(dps.toString())

            mainActivityView?.setHitPoints(unit.hit_points.toString())

            val lineOfSight = calculatelineOfSight(unit.line_of_sight)
            mainActivityView?.setLineOfSight(lineOfSight)
        }



    }

    }
