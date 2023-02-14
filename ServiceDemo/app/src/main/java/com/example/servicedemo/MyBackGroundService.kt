package com.example.servicedemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyBackGroundService : Service() {
    override fun onBind(p0: Intent?): IBinder? = null

    companion object {
        const val TAG = "MyTag"
        const val NAME = "name"
        const val AGE = "age"
    }

    init {
        Log.e(TAG, "Service has been created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG, "Service started")
        val name = intent?.getStringExtra(NAME)
        val age = intent?.getIntExtra(AGE, 0)
        Log.e(TAG, "He is $name and he is $age year old now")
        return START_STICKY
    }

    override fun onDestroy() {
        Log.e(TAG, "Destroying....")
        super.onDestroy()
    }
}