package com.example.newexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class MainViewModel :ViewModel(){
    //var count=0
    var count=MutableLiveData<Int>()

    init {
        count.value=0
        Timber.i("View Model Created")
    }
    fun increament(){
        count.value=count.value?.plus(1)//? or !! value for sure or null safe
    }
    fun decreament(){
        count.value=count.value?.minus(1)//? or !! value for sure or null safe
    }
}