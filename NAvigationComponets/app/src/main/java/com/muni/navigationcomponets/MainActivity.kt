package com.muni.navigationcomponets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Set replace Main Activity content with the Fragment1 content
        val RedFragment = RedFragment()
        supportFragmentManager.beginTransaction().replace(R.id.content_id, RedFragment).commit()

    }


}
