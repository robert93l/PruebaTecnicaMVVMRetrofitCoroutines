package com.example.pruebatecnicamvvmretrofitcoroutines.domain.repository

import com.example.pruebatecnicamvvmretrofitcoroutines.domain.repository.model.RandomUser
import com.example.pruebatecnicamvvmretrofitcoroutines.domain.repository.util.Resource

interface RandomUserRepository {

    suspend fun fetchRandomUser(): Resource<RandomUser>
}