package com.example.notificationexample

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {

    companion object {
        const val channelId = "channelId"
        const val channelName = "channelName"

        const val replyKey = "replyKey"
    }


    private lateinit var notificationManager: NotificationManager

    private lateinit var notiButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        createChannel()
        notiButton = findViewById(R.id.notiButton)


        notiButton.setOnClickListener {

//For the latest versions, please use PendingIntent.FLAG_IMMUTABLE instead of  PendingIntent.FLAG_UPDATE_CURRENT
            if (isNotificationPermissionGranted()) {
                showNoti()
            } else {
                requestNotificationPermission()
            }

        }


    }

    private fun showNoti() {


        val id = 45


        val tapResultInent = Intent(
            this,
            SecondActivity::class.java
        )

        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            tapResultInent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val actionIntent = Intent(
            this,
            ThirdActivity::class.java
        )

        val actionPendingInent = PendingIntent.getActivity(
            this,
            0,
            actionIntent,
            PendingIntent.FLAG_IMMUTABLE
        )


        val messageIntent = Intent(
            this,
            FourthActivity::class.java
        )

        val messagePendingIntent = PendingIntent.getActivity(
            this,
            0,
            messageIntent,
            PendingIntent.FLAG_MUTABLE
        )


        val remoteInput: RemoteInput = RemoteInput.Builder(replyKey).run {

            setLabel("NAME PLASEE")
            build()
        }


        val replyAction = NotificationCompat.Action.Builder(
            0,
            "REPLY",
            messagePendingIntent
        ).addRemoteInput(remoteInput).build()
        val action: NotificationCompat.Action =
            NotificationCompat.Action.Builder(0, "THIRD", actionPendingInent).build()

        val noti = NotificationCompat.Builder(
            this,
            channelId
        ).setContentTitle("notinotinotinoti")
            .setContentText("itonitonitoniton")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .addAction(action)
            .addAction(replyAction)
            .build()

        notificationManager.notify(id, noti)


    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = channelName
            }
            notificationManager.createNotificationChannel(channel)
        }

    }


    fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    1
                )
            }
        }
    }

    fun isNotificationPermissionGranted(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
    }


}