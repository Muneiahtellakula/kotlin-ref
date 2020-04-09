package com.muni.mycalender

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.muni.mycalender.databinding.ActivityMainBinding
import java.util.*

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
        databinding.eventBtn.setOnClickListener { getEvent() }

    }

    private fun getEvent() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
      //  val event =findViewById<EditText>(R.id.event)
        val c : Calendar = Calendar.getInstance()
        val intent = Intent(Intent.ACTION_EDIT)
        intent.setType("vnd.android.cursor.item/event")
        intent.putExtra("startTime",c.timeInMillis)
        intent.putExtra("endTime",c.timeInMillis+60+60+1000)
        /*For Add Event Static*/
        //intent.putExtra("title","Birthday")
        /*For Add Event Dynamically*/
        intent.putExtra("title",databinding.event.text.toString())
        startActivity(intent)
    }
}
