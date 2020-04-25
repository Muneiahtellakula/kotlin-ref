package com.muneiah.cricketscoreapp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ScoreMainViewModelFactory(val application: Application) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ScoreMainViewModel(application) as T
    }

}