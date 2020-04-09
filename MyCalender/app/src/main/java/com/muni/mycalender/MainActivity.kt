package com.muni.mycalender

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.muni.mycalender.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var databinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       databinding= DataBindingUtil.setContentView(this,R.layout.activity_main)
      databinding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Note that months are indexed from 0. So, 0 means January, 1 means february, 2 means march etc.
            val msg = "Selected date is " + dayOfMonth + "/" + (month + 1) + "/" + year
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
          databinding.textView.text=msg
        }

    }
}
