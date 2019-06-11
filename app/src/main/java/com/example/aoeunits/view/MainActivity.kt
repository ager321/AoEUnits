package com.example.aoeunits.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.aoeunits.R
import com.example.aoeunits.model.AoEDataReciver
import com.example.aoeunits.model.AoEUnitAPI
import com.example.aoeunits.model.AoEUnitDTO
import com.example.aoeunits.model.AoEUnitValue
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


class MainActivity : AppCompatActivity(), MainActivityView {
    private lateinit var mainPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter = MainActivityPresenter(this, AoEDataReciver())

        Stetho.initializeWithDefaults(this)




    }

    fun switchToUnitsList(view: View) {
        val intent = Intent(this, UnitsListActivity::class.java)
        startActivity(intent)
    }
}

