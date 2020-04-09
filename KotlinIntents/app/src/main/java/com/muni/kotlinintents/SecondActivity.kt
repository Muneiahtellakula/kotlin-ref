package com.muni.kotlinintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muni.kotlinintents.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
lateinit var datbinding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

    }
}
