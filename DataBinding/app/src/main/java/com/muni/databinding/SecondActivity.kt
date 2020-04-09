package com.muni.databinding

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Intents.Insert.ACTION
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.muni.databinding.databinding.ActivitySecondBinding
import kotlinx.android.synthetic.main.activity_second.*
import java.text.SimpleDateFormat
import java.util.*

class SecondActivity : AppCompatActivity() {
lateinit var databinding:ActivitySecondBinding

    //for Calender date picker
    var cal = Calendar.getInstance()
    var button_date: Button? = null
    var textview_date: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        val intent = getIntent()
        databinding.tvSecond.text = intent.getStringExtra("msg")
        databinding.tvSecond.setOnClickListener { openCamera() }
// get the references from layout file
        textview_date = this.text_view_date_1
        button_date = this.button_date_1
        textview_date!!.text = "--/--/----"
// create an OnDateSetListener
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }
// when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        button_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(baseContext,
                    dateSetListener,
// set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })


    }
    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textview_date!!.text = sdf.format(cal.getTime())
    }



    private fun openCamera() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val i=Intent()
        i.setAction(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(i,200)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 200){
            if(resultCode == Activity.RESULT_OK && data != null){
                val img = data.getParcelableExtra<Bitmap>("data")
                val iv = findViewById<ImageView>(R.id.iv_second)
                iv.setImageBitmap(img)
            }
        }
    }
}
