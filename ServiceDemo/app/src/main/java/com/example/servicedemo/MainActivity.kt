package com.example.servicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.servicedemo.MyBackGroundService.Companion.TAG
import com.example.servicedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val serviceIntent = Intent(this, MyBackGroundService::class.java)
        serviceIntent.putExtra(MyBackGroundService.NAME, "Dat")
        serviceIntent.putExtra(MyBackGroundService.AGE, 20)

        binding.btnStart.setOnClickListener {
            Log.e(MyBackGroundService.TAG, "Starting Service")
            startService(serviceIntent)
        }

        binding.btnStop.setOnClickListener {
            Log.e(MyBackGroundService.TAG, "Stopping service")
            stopService(serviceIntent)
        }
    }
}