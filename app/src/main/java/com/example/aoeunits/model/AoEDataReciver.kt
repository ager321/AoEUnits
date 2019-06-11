package com.example.aoeunits.model

import android.util.Log
import com.facebook.stetho.okhttp3.StethoInterceptor
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import android.os.AsyncTask.execute
import kotlinx.coroutines.*
import java.io.IOException
import java.lang.Runnable


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

}