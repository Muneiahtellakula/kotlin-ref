package com.muneiah.workermanagerkotlin_test

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.databinding.DataBindingUtil
import com.muneiah.workermanagerkotlin_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var databinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        databinding.btn.setOnClickListener {
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationChannel: NotificationChannel =
                    NotificationChannel(
                        "notification_id",
                        "myNotification",
                        NotificationManager.IMPORTANCE_HIGH
                    )
                    notificationChannel.lightColor=Color.WHITE
                    notificationChannel.enableVibration(true)
                notificationChannel.description="For testing "
                notificationChannel.enableLights(true)
                notificationManager.createNotificationChannel(notificationChannel)


            }
                val notification=NotificationCompat.Builder(this,"notification_id")
                notification.setSmallIcon(R.drawable.ic_notifications_none_black_24dp)
        }
    }


}
