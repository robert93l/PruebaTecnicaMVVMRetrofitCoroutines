package com.example.pruebatecnicamvvmretrofitcoroutines.data.remote.mappers

import com.example.pruebatecnicamvvmretrofitcoroutines.data.remote.response.Result
import com.example.pruebatecnicamvvmretrofitcoroutines.domain.repository.model.RandomUser

fun Result.toDomain(): RandomUser{
    return RandomUser(
        name = "${this.name.first} ${this.name.last}",
        email = this.email,
        birthday = this.dob.date,
        age = this.dob.age,
        address = "${this.location.state} ${this.location.city}",
        phone = this.phone,
        password = this.login.password,
        photo = this.picture.large
    )
}