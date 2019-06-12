package com.example.aoeunits.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.aoeunits.R
import com.example.aoeunits.model.*
import com.example.aoeunits.presenter.MainActivityPresenter
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Component
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import javax.inject.Inject
import com.example.aoeunits.model.ButtonsInfo



class MainActivity : AppCompatActivity(), MainActivityView {
    private lateinit var mainPresenter: MainActivityPresenter
    @Inject lateinit var info: ButtonsInfo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter = MainActivityPresenter(this, AoEDataReciver())
        Stetho.initializeWithDefaults(this)

        DaggerButtonInfoComponent.create().inject(this)
        units_button.text = info.list_button_info
        find_button.text = info.find_button_info
    }

//    override fun setData() {
//        val unit = mainPresenter.getData("militia")
//
//        description.text = unit?.description
//        attack_val.text = unit?.attack.toString()
//        reload_val.text = unit?.reloadTime.toString()
//        hp_val.text = unit?.hitPoints.toString()
//
//        description.text = unit?.description
//        description.text = unit?.description
//
//    }

    override fun setDescription(Description: String){
        description.text = Description
    }

    override fun setAttackValue(AttackValue: String) {
        attack_val.text = AttackValue
    }
    override fun setReloadTime(ReloadTime: String) {
        reload_val.text = ReloadTime
    }

    override fun setDPS(DPS: String) {
        dps_val.text = DPS
    }

    override fun setHitPoints(HitPoints: String) {
        hp_val.text = HitPoints
    }

    override fun setLineOfSight(LineOfSight: String) {
        line_of_sight_val.text = LineOfSight
    }



    fun findUnit(view: View) {
        val name = unit_name.text.toString()
        mainPresenter.setData(name)
    }


    fun switchToUnitsList(view: View) {
        val intent = Intent(this, UnitsListActivity::class.java)
        startActivity(intent)
    }
}

