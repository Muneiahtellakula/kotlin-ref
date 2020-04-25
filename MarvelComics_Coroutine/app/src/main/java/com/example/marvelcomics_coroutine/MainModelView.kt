package com.example.marvelcomics_coroutine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainModelView :ViewModel(){

    var data= MutableLiveData<DataList>()


}