package com.example.coroutinedemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutinedemo2.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var count = -1

        binding.apply {
            btnDownload.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    downloadUsersData()
                }
            }

            btnCount.setOnClickListener {
                tvCount.text = count++.toString()
            }
        }
    }

   private suspend fun downloadUsersData() {
        for (i in 0..200000) {
            withContext(Dispatchers.Main) {
                binding.tvDownload.text = "Download $i in ${Thread.currentThread().name}"
            }
        }
    }
}