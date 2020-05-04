package com.muneiah.districtwisecovid19in

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv=findViewById(R.id.tv_res)
        CoroutineScope(Dispatchers.IO).launch {
            val service = instance.districJsonApiService()
            val response = service.getData()
            if(response.isSuccessful){
                withContext(Dispatchers.Main){
                    val l = response.body()
                    tv.text = ""
                    for(i in l){
                        tv.append(i.body+"\n")
                    }
                }
            }

        }

    }
    object instance{
        fun districJsonApiService(): DistricJsonApiService{
            val okhttp = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()


            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val retrofit = Retrofit.Builder()
               // .baseUrl("https://jsonplaceholder.typicode.com/")
                .baseUrl("https://api.covid19india.org/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(okhttp)
                .build()

            val districJsonApiService : DistricJsonApiService = retrofit.create(DistricJsonApiService::class.java)

            return districJsonApiService
        }
    }
}
