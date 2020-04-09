package com.muni.kotlinintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.muni.kotlinintents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var databinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        databinding.btnId.setOnClickListener { openSecondActivity() }
    }

    private fun openSecondActivity() {
        val m=databinding.etMain.text.toString()
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val intent=Intent(this,SecondActivity::class.java)
        intent.putExtra("msg",m)
        startActivity(intent)

    }
}
