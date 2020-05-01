package com.muneiah.jsonplaceholderretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity() : AppCompatActivity(){

    lateinit var tv : TextView
    lateinit var getBtn : Button
    lateinit var postBtn : Button

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        * By Default, the retrofit library will only wait for 10 seconds
        * to establish a connection, to fetch data or to write data*/

        tv = findViewById(R.id.respons)
        getBtn = findViewById(R.id.button_get)
        postBtn = findViewById(R.id.button_post)

        /*To Increase the Time */


        getBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val service = instance.jsonPlaceHolderInstance()
                val response = service.getAllValues()
                if(response.isSuccessful){
                    withContext(Dispatchers.Main){
                        val l = response.body()
                        tv.text = ""
                        for(i in l!!){
                            tv.append(i.body+"\n")
                        }
                    }
                }

            }
        }

        postBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val service = instance.jsonPlaceHolderInstance()
                val post = Post(body = "My Body",title = "My Title",userId = 90)
                val response = service.postValue(post)
                if(response.isSuccessful){
                    withContext(Dispatchers.Main){
                        val post = response.body()
                        tv.text =""
                        tv.append(""+post?.id)
                    }
                }
            }
        }

    }

    object instance{
        fun jsonPlaceHolderInstance(): JsonPlaceHoldserService{
            val okhttp = OkHttpClient.Builder()
                .connectTimeout(1,TimeUnit.MINUTES)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .build()


            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(okhttp)
                .build()

            val jsonPlaceHolderService : JsonPlaceHoldserService = retrofit.create(JsonPlaceHoldserService::class.java)

            return jsonPlaceHolderService
        }
    }
}