package com.example.pruebatecnicamvvmretrofitcoroutines.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicamvvmretrofitcoroutines.domain.repository.RandomUserRepository
import com.example.pruebatecnicamvvmretrofitcoroutines.domain.repository.model.RandomUser
import com.example.pruebatecnicamvvmretrofitcoroutines.domain.repository.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RandomUserRepository
) : ViewModel() {

    private val _randomUserState =  MutableLiveData<Resource<RandomUser>>()
    val randomUserState : LiveData<Resource<RandomUser>>
    get() = _randomUserState

    private val _isloading =  MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean>
        get() = _isloading

    init{
        getRandomUser()
    }

    fun getRandomUser(){
        viewModelScope.launch {
            _isloading.value = true
            _randomUserState.value = repository.fetchRandomUser()
            _isloading.value = false
        }
    }
}