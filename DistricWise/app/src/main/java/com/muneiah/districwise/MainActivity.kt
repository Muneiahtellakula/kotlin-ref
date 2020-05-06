package com.muneiah.districwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var tv: TextView
    lateinit var tv_dec: TextView
    lateinit var btn: Button
    lateinit var iv: ImageView
    val int = 100;
    val BASE_URL: String ="https://api.covid19india.org/districts_daily.json"
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showData(view: View) {


    }
    private suspend fun fetchData() {
        val url = URL(BASE_URL)
        val httpconn: HttpURLConnection = url.openConnection() as HttpURLConnection
        val input_stream: InputStream = httpconn.inputStream
        val text = input_stream.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main) {
            setValueOnResult(text)
        }

    }

    private fun setValueOnResult(text: String) {
        progressBar.visibility = View.GONE
        val rootObj: JSONObject = JSONObject(text)




    }

}
