package com.example.pruebatecnicamvvmretrofitcoroutines.data.remote

import com.example.pruebatecnicamvvmretrofitcoroutines.data.remote.mappers.toDomain
import com.example.pruebatecnicamvvmretrofitcoroutines.domain.repository.RandomUserRepository
import com.example.pruebatecnicamvvmretrofitcoroutines.domain.repository.model.RandomUser
import com.example.pruebatecnicamvvmretrofitcoroutines.domain.repository.util.Resource
import java.lang.Exception
import javax.inject.Inject


class RandomUserRepositoryImpl @Inject constructor(private val randomUserApi:RandomUserApi):RandomUserRepository {

    override suspend fun fetchRandomUser(): Resource<RandomUser> {
    return try{
            Resource.Success(
                data = randomUserApi.fetchRandomUser().results.first().toDomain()
            )
    }catch (e:Exception){
        Resource.Error(
            message = "Unknow error"
        )
    }
    }
}