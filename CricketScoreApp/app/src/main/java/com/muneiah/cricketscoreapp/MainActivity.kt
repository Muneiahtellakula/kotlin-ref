package com.muneiah.cricketscoreapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.muneiah.cricketscoreapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var dataBinding: ActivityMainBinding
    var run = 0
    var wickets: Int = 0
    var over: Int = 0
    var balls: Int = 0
    var A = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }


    fun endInnings(view: View?) {
        if (!A) {
            reset(view)
        } else {
            A = false
            run = 0
            wickets = 0
            over = 0
            balls = 0
            dataBinding.endInnings.text = "End 2nd Inninigs"
        }
    }

    fun submitRuns(view: View?) {
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
    }

    fun submitWide(view: View?) {
        val wide = findViewById<View>(R.id.wides) as EditText
        run = run + wide.text.toString().toInt()
        if (A) {
            setScoreA()
        } else {
            setScoreB()
        }
    }

    fun submitWickets(view: View?) {
        balls++
        if (balls > 6) {
            balls = 0
            over++
        }
        if (wickets < 10) wickets++ else {
            if (A) {
                endInnings(view)
            } else {
                val end =
                    findViewById<View>(R.id.endInnings) as Button
                end.text = "Reset"
                val editor =
                    findViewById<View>(R.id.editor) as LinearLayout
                editor.visibility = View.INVISIBLE
            }
        }
        if (A) {
            setOversA()
            setScoreA()
        } else {
            setScoreB()
            setOversB()
        }
    }

    fun setOversA() {
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
    }

    fun reset(view: View?) {
        run = 0
        wickets = 0
        over = 0
        balls = 0
        A = true
        setOversA()
        setOversB()
        setScoreA()
        setScoreB()
        dataBinding.editor.visibility = View.VISIBLE
        dataBinding.endInnings.text = "End innings"
    }
}
