package id.kotlin.belajar

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class BelajarMessaging : FirebaseMessagingService() {

  override fun onMessageReceived(remoteMessage: RemoteMessage) {
    val data = remoteMessage.data
    val title = data["title"] ?: "Untitled"
    val description = data["description"] ?: "No Description"
    sendNotification(title, description)
  }

  override fun onNewToken(token: String) {
    Log.d(BelajarMessaging::class.java.simpleName, token)
  }

  private fun sendNotification(title: String, description: String) {
    val channelId = resources.getString(R.string.channel_id)
    val soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
    val notificationBuilder = NotificationCompat.Builder(this, channelId).apply {
      setSmallIcon(R.drawable.ic_launcher_foreground)
      setContentTitle(title)
      setContentText(description)
      setAutoCancel(true)
      setSound(soundUri)
    }.build()

    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      val channel = NotificationChannel(
          channelId,
          title,
          NotificationManager.IMPORTANCE_DEFAULT
      ).apply {
        enableLights(true)
        lightColor = Color.WHITE
        enableVibration(true)
      }

      notificationManager.createNotificationChannel(channel)
    }

    notificationManager.notify(300, notificationBuilder)
  }
}