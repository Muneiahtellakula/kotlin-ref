package com.example.assignment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.assignment5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var databinding: ActivityMainBinding
    var words = ""
    var mAlphaArray : MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        databinding.buttonUpdate.setOnClickListener {
            mAlphaArray  = mutableListOf(
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G",
                "H",
                "I",
                "J"
            )
            selectWordS()

            databinding.textViewValue.text=words.toString()

        }

    }

    fun selectWordS() {
        if (mAlphaArray.isEmpty()) {
            words = "ALL WORDS ARE COMPLETE"
        } else {
            words = mAlphaArray.removeAt(0)
        }
    }
}
