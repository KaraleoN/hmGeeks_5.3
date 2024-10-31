package com.example.retrofit.data.Services

import com.example.retrofit.data.model.PercentageModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApiService {

    @GET("getPercentage")
    fun fetchPercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("x-rapidapi-key") key: String,
        @Header("X-rapidapi-host") host: String,
    ): Call<PercentageModel>

}