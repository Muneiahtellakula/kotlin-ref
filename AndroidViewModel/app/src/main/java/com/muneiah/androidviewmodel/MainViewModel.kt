package com.muneiah.androidviewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){
    var c=MutableLiveData<Int>()

    init {
        c.value=0
    }

    fun increaseCount(){

        c.value=c.value?.plus(1)

    }
    fun showToast(context: Context){
        Toast.makeText(context
            ,"count is :"+c.toString(), Toast.LENGTH_SHORT).show()
    }
}