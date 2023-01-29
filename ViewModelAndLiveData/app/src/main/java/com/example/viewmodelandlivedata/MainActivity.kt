package com.example.viewmodelandlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val tvCount = findViewById<TextView>(R.id.tvCount)
        val btnCount = findViewById<Button>(R.id.btnCount)

        mainActivityViewModel.count.observe(this, Observer {
            tvCount.text = it.toString()
        })

        btnCount.setOnClickListener {
            mainActivityViewModel.update()
        }
    }
}