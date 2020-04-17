package com.example.catfactscoretis

import android.content.Context
import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {
    lateinit var result: TextView
    lateinit var result2: TextView
    val LINK: String = "https://cat-fact.herokuapp.com/facts"
    val LINK2: String = "https://raw.githubusercontent.com/LearnWebCode/json-example/master/animals-1.json"
    lateinit var progress:ProgressBar
    lateinit var progress2:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result = findViewById(R.id.textView)
        result2 = findViewById(R.id.textView2)
        val btn = findViewById<Button>(R.id.button)
        val btn2 = findViewById<Button>(R.id.button2)
        progress=findViewById(R.id.progressbar)
        progress2=findViewById(R.id.progressbar2)
        progress.visibility=View.GONE
        progress2.visibility=View.GONE
        btn.setOnClickListener {
            progress.visibility=View.VISIBLE
            /*fetchCatFacts(this,result).execute(LINK)*/
            CoroutineScope(Dispatchers.IO).launch {
                 fetchRandomJSON()
            }
        }
        btn2.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                fetchRandomJSON2()
            }
        }


    }

    private suspend fun fetchRandomJSON2() {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val url = URL(LINK2)
        val httpsURLConnection : HttpsURLConnection = url.openConnection() as HttpsURLConnection
        val inputStream : InputStream = httpsURLConnection.inputStream
        val text = inputStream.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main){
            setValueOnResult3(text)
        }
    }

    private suspend fun fetchRandomJSON() {
        /*Run this code in a background thread - UI Should'nt be accessed*/
        val url = URL(LINK)
        val httpsURLConnection : HttpsURLConnection = url.openConnection() as HttpsURLConnection
        val inputStream : InputStream = httpsURLConnection.inputStream
        val text = inputStream.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main){
            setValueOnResult2(text)
        }
    }

    private fun setValueOnResult2(text: String) {
          progress.visibility=View.GONE
            result.text=text
    }
    private fun setValueOnResult3(text: String) {
        progress.visibility=View.GONE
        result2.text=text
    }
}

/* *//*  suspend fun fetchFacts() {
            val url = URL(LINK)
            val httpsUrlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
            val inpustreem: InputStream = httpsUrlConnection.inputStream
            // val br:BufferedReader= BufferedReader(InputStreamReader(inpustreem))
            val text = inpustreem.bufferedReader().use(BufferedReader::readText)
            withContext(Dispatchers.Main) {
                setValueOnresult(text)
            }
        }*//*


    }

    private fun fetchFacts() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val url = URL(LINK)
        val httpsUrlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        val inpustreem: InputStream = httpsUrlConnection.inputStream
        // val br:BufferedReader= BufferedReader(InputStreamReader(inpustreem))
        val text = inpustreem.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main) {
            setValueOnresult(text)
        }
    }
*//*https://raw.githubusercontent.com/LearnWebCode/json-example/master/animals-1.json*//*

    private fun setValueOnresult(text: String) {

    }

    *//*  private fun setValueOnresult(text: String): {
            result.text = text
        }*//*

}

*//* class  fetchCatFacts(val context:Context,val  result :TextView): AsyncTask<String, Void, String>() {
     val link=""
     override fun doInBackground(vararg params: String?): String {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
         val LINK=params[0]
      //   val uri= Uri.parse(LINK)
         val url=URL(LINK)
         val httpsUrlConnection:HttpURLConnection= url.openConnection() as HttpURLConnection
         val inpustreem:InputStream=httpsUrlConnection.inputStream
        // val br:BufferedReader= BufferedReader(InputStreamReader(inpustreem))
         val text=inpustreem.bufferedReader().use(BufferedReader::readText)
         return text


     }
//parse the json data
     override fun onPostExecute(r: String?) {
         super.onPostExecute(r)
         result.text=r
     }


 }*//*

*/