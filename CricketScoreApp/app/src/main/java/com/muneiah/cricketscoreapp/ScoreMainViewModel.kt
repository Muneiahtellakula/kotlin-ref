package com.muneiah.cricketscoreapp

import android.app.Application
import android.view.View
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

    init {
        scoreReproisitory = ScoreReproisitory(application)
        total_score = scoreReproisitory.getAll()

    }
    fun insert(scoredetailsEntity: ScoreDetails_Entity) {
        scoreReproisitory.insert(scoredetailsEntity)
    }

    /*fun endInnings(view: View?) {
        if (!A) {
            reset(view)
        } else {
            A = false
            run = 0
            wickets = 0
            over = 0
            balls = 0
            // dataBinding.endInnings.text = "End 2nd Inninigs"
        }

    }*/


   /* fun reset(view: View?) {
        run = 0
        wickets = 0
        over = 0
        balls = 0
        A = true
        setOversA()
        setOversB()
        setScoreA()
        setScoreB()
       *//* dataBinding.editor.visibility = View.VISIBLE
        dataBinding.endInnings.text = "End innings"*//*
    }*/
   /* fun submitRuns(view: View?) {
        // runs = findViewById<View>(R.id.runs) as EditText
        run = run + dataBinding.runs!!.text.toString().toInt()
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
    }*/
  /*  fun setOversA() {
        dataBinding.oversA!!.text = over.toString() + "." + balls

    }

    fun setOversB() {
        dataBinding.oversB!!.text = over.toString() + "." + balls
    }

    fun setScoreA() {
        dataBinding.scoreA!!.text = "$run/$wickets"
    }

    fun setScoreB() {
        dataBinding.scoreB!!.text = "$run/$wickets"
    }*/

}
