package com.example.aoeunits.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AoEUnitAPI {
    @GET("/api/v1/units")
    fun loadUnits() : Call<AoEUnitDTO>

    @GET("/api/v1/unit/{name}")
    fun loadUnit(@Path("name")name: String) : Call<AoEUnitValue>
}
