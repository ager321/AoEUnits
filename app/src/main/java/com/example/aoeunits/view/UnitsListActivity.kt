package com.example.aoeunits.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity;
import com.example.aoeunits.R
import com.example.aoeunits.model.AoEDataReciver
import com.example.aoeunits.model.AoEUnitValue
import com.example.aoeunits.presenter.MainActivityPresenter
import com.example.aoeunits.presenter.UnitsListPresenter

import kotlinx.android.synthetic.main.activity_units_list.*

class UnitsListActivity : AppCompatActivity(), UnitsListView {

    private lateinit var unitListPresenter: UnitsListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_units_list)
        unitListPresenter = UnitsListPresenter(this, AoEDataReciver())
        setUnitsData()




    }


    override fun setUnitsData(){
        val listOfUnits: ArrayList<AoEUnitValue>? = unitListPresenter.getData()
        //description.text = listOfUnits?.get(6)?.description

        val fm = supportFragmentManager
        var fragment = fm.findFragmentById(R.id.fragment_container)

        // ensures fragments already created will not be created
        if (fragment == null) {
            fragment = MainFragment.newInstance()
            // create and commit a fragment transaction
            fm.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}

