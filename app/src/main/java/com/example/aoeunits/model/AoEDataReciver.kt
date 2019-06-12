package com.example.aoeunits.model

import android.util.Log
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class AoEDataReciver {

var listOfUnits : ArrayList<AoEUnitValue>? = null
private val aoeAPI : AoEUnitAPI

    init{
        val okHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://age-of-empires-2-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        aoeAPI = retrofit.create(AoEUnitAPI::class.java)

    }
    fun getUnits() : ArrayList<AoEUnitValue>?
    {
        if(listOfUnits == null)
        {
            val call = aoeAPI.loadUnits()

            val thread: Thread = object: Thread(){
                override fun run(){
                    try {
                        val response: Response<AoEUnitDTO> = call.execute()
                        listOfUnits = response.body()?.units

                    } catch (e: IOException) {
                        Log.d("api fail", "api load failure")
                    }
                }
            }

            thread.start()
            thread.join()
        }

        return listOfUnits
    }
    fun getUnit(name: String) : AoEUnitValue?
    {
        var unit: AoEUnitValue? = null
        val call = aoeAPI.loadUnit(name)

        val thread: Thread = object: Thread(){
            override fun run(){
                    try {
                        val response: Response<AoEUnitValue> = call.execute()
                            unit = response.body()

                    } catch (e: IOException) {
                        Log.d("api fail", "api load failure")
                    }
                }
            }

        thread.start()
        thread.join()
        Log.d("api fail", "halo ${unit?.hit_points}")
        return unit
    }




}