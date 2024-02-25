package com.roman.clildlearning

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.roman.clildlearning.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding : ActivityMain2Binding

    //Notification create
    //channel create
    val CHANNEL_ID = "channelId"
    val CHANNEL_NAME = "channelName"
    val notificationId = 1

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //video screen
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.kidvid3 );
        binding.bgVideoView.setVideoURI(videoUri);
        binding.bgVideoView.start();
        binding.bgVideoView.setOnCompletionListener {
            binding.bgVideoView.start();
        }

        binding.cardGeneral.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.kidVideo.setOnClickListener{
            val intent = Intent(this, KidVideo::class.java)
            startActivity(intent)
        }




        //Notification code start
        createNotificationChannel()
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Hi, Roman Molla")
            .setContentText("Congratulation for new app")
            .setSmallIcon(R.drawable.enlogo)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)
        binding.notiBtn.setOnClickListener{
            notificationManager.notify(notificationId, notification)
        }



    }

   private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "This is my notification channel"
//                lightColor = Color.GREEN
//                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

    }
}