package com.orangecash.app

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

class NotificationService(private val context: Context) {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    private val channelId = "orange_cash_channel"

    init {
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            channelId,
            "Orange Cash Notifications",
            NotificationManager.IMPORTANCE_HIGH
        )
        notificationManager.createNotificationChannel(channel)
    }

    fun showTransferSuccess(amount: String, phone: String, fee: String) {
        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("عملية تحويل ناجحة")
            .setContentText("تم تحويل مبلغ $amount ج.م الى رقم $phone بنجاح. رسوم التحويل $fee جنيه.")
            .setAutoCancel(true)
            .build()

        notificationManager.notify(1, notification)
    }
}
