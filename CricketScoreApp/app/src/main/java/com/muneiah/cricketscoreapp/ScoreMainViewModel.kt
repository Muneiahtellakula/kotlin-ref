package com.muneiah.cricketscoreapp

import android.app.Application
import android.view.View
import android.widget.EditText
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


class ScoreMainViewModel(application: Application): AndroidViewModel(application) {
    val scoreReproisitory: ScoreReproisitory
    val total_score: LiveData<List<ScoreDetails_Entity>>
    var run = 0
    var wickets: Int = 0
    var over: Int = 0
    var balls: Int = 0
    var A = true
    var oversA:Int=0
    var oversB:Int=0

    init {
        scoreReproisitory = ScoreReproisitory(application)
        total_score = scoreReproisitory.getAll()

    }
    fun insert(scoredetailsEntity: ScoreDetails_Entity) {
        scoreReproisitory.insert(scoredetailsEntity)
    }

    fun submitRuns() {
       // run = run + dataBinding.runs!!.text.toString().toInt()
        balls++
        if (balls > 6) {
            balls = 0
            over++
        }
        if (A) {
            setScoreA()
            setOversA()
        } else {
            setScoreB()
            setOversB()
        }
    }

    fun submitWide() {
       //run = run + wide.text.toString().toInt()
        if (A) {
            setScoreA()
        } else {
            setScoreB()
        }
    }

    fun setOversA() {
       // oversA = over + "." + balls

    }

    fun setOversB() {
      //  dataBinding.oversB!!.text = over.toString() + "." + balls
    }

    fun setScoreA() {
       // dataBinding.scoreA!!.text = "$run/$wickets"
    }

    fun setScoreB() {
      //  dataBinding.scoreB!!.text = "$run/$wickets"
    }

}
