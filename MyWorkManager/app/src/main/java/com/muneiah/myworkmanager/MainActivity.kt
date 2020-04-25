package com.muneiah.myworkmanager

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.net.Network
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.lifecycle.Observer
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var constraints: Constraints
    lateinit var workRequest: WorkRequest


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.enquee_btn)
        constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
       /* workRequest= OneTimeWorkRequestBuilder<MyWorker>()
            .setConstraints(constraints)
            .build()*/
        workRequest = PeriodicWorkRequestBuilder<MyWorker>(1, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        btn.setOnClickListener {
            //showNotification()
            WorkManager.getInstance(this).enqueue(workRequest)
        }
        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(workRequest.id)
            .observe(this, Observer { workInfo ->
                val tv: TextView = findViewById(R.id.textView)
                if (workInfo != null && workInfo.state == WorkInfo.State.SUCCEEDED) {
                    tv.text = "SUCCEEDED"
                }
                if (workInfo != null && workInfo.state == WorkInfo.State.BLOCKED) {
                    tv.text = "BLOCKED"
                }
                if (workInfo != null && workInfo.state == WorkInfo.State.ENQUEUED) {
                    tv.text = "ENQUEUED"
                }
                if (workInfo != null && workInfo.state == WorkInfo.State.RUNNING) {
                    tv.text = "RUNNING"
                }
                if (workInfo != null && workInfo.state == WorkInfo.State.FAILED) {
                    tv.text = "FAILED"
                }

            })
    }

    /* private fun showNotification() {

         val notificationManager:NotificationManager= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
         if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
             val notificationChannel :NotificationChannel=NotificationChannel("NOTIFY","MyChannnel",NotificationManager.IMPORTANCE_HIGH)
             notificationChannel.lightColor=Color.WHITE
             notificationChannel.enableVibration(true)
             notificationChannel.description="My Notificationchanel"
             notificationManager.createNotificationChannel(notificationChannel)

         }
         val notification =NotificationCompat.Builder(this,"NOTIFY")
             .setContentTitle("Work Finished")
             .setContentText("Me Muneiah work completed")
             .setSmallIcon(R.mipmap.ic_launcher)
             .build()
         notificationManager.notify(22,notification)
     }

 */

}
