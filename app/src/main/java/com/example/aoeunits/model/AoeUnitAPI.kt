package com.example.aoeunits.model

import retrofit2.Call
import retrofit2.http.GET

interface AoEUnitAPI {
    @GET("/api/v1/units")
    fun loadUnits() : Call<AoEUnitDTO>
}
