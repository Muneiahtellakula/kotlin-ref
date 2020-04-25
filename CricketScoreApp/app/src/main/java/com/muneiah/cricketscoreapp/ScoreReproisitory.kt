package com.muneiah.cricketscoreapp

import android.app.Application
import androidx.lifecycle.LiveData

class ScoreReproisitory (application: Application){
    private val scoreDao : ScoreDao
    private val scorelist : LiveData<List<ScoreDetails_Entity>>



    init {
        val scoreDataBase:ScoreDataBase = ScoreDataBase.getInstance(application)
        scoreDao = scoreDataBase.scoreDao
        scorelist = scoreDao.getAll()
    }

    fun getAll(): LiveData<List<ScoreDetails_Entity>> {
        return scorelist
    }

    fun insert(scoredetailsEntity: ScoreDetails_Entity){
        scoreDao.insert(scoredetailsEntity)
    }
}