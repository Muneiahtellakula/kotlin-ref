package com.muneiah.myworkmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MyWorker (val context:Context,workerParameters: WorkerParameters):Worker(context,workerParameters){
    override fun doWork(): Result {
        CoroutineScope(Dispatchers.Main).launch {
            waitForFiveSecond(context)
        }
       // showNotification(context)
        return Result.success()
    }

    suspend fun waitForFiveSecond(context: Context){
    Thread.sleep(5000)
        showNotification(context)
    }



    private fun showNotification(context: Context) {
        val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val notificationChannel : NotificationChannel =
                NotificationChannel("NOTIFY","MyChannnel", NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.lightColor= Color.WHITE
            notificationChannel.enableVibration(true)
            notificationChannel.description="My Notificationchanel"
            notificationManager.createNotificationChannel(notificationChannel)

        }
        val notification = NotificationCompat.Builder(context,"NOTIFY")
            .setContentTitle("Work Finished")
            .setContentText("Me Muneiah work completed")
            .setSmallIcon(R.mipmap.ic_launcher)
            .build()
        notificationManager.notify(22,notification)
    }

}