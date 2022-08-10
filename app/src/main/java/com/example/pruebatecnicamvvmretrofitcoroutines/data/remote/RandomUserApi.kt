package com.example.pruebatecnicamvvmretrofitcoroutines.data.remote

import com.example.pruebatecnicamvvmretrofitcoroutines.data.remote.response.ResponseDto
import retrofit2.http.GET

interface RandomUserApi{

    @GET("/api/")
    suspend fun fetchRandomUser(): ResponseDto



}