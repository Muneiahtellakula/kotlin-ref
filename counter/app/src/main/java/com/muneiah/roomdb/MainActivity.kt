package com.muneiah.roomdb

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.ViewSwitcher
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mAdView : AdView

    val pray = arrayListOf("muni","reddy", "Pav","Krish", "Anu","vali", "sai","vara","chai","pal","siv")
    var currentText = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var added = 0

        add.setOnClickListener {
            added++
            cot.text = added.toString()
        }
        reset.setOnClickListener {
            added=0
            cot.text = added.toString()
        }

        nex.setOnClickListener {

        }
        val inAnimation = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left)
        val outAnimation = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right)
        swit.setFactory(object: ViewSwitcher.ViewFactory{
            override fun makeView(): View {
                val switcherTextView = TextView(this@MainActivity)
                switcherTextView.textSize=20f
                switcherTextView.gravity= Gravity.CENTER
                switcherTextView.setTextColor(Color.WHITE)
                return switcherTextView
            }

        })

        swit.inAnimation=inAnimation
        swit.outAnimation=outAnimation

        swit.setText(pray[currentText])
        nex.setOnClickListener {
            if (currentText !=8)
                currentText++
            else
                currentText = 0
            swit.setText(pray[currentText])
        }
        swit.setText(pray[currentText])
        prev.setOnClickListener {
            if (currentText >0)
                currentText--
            else
                currentText = 8
            swit.setText(pray[currentText])
        }
        MobileAds.initialize(this)
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }
    private operator fun invoke(string: String): Context? {
        return null

    }
}
