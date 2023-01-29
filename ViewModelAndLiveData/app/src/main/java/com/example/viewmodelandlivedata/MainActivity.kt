package com.example.viewmodelandlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val tvCount = findViewById<TextView>(R.id.tvCount)
        val btnCount = findViewById<Button>(R.id.btnCount)

        tvCount.text = mainActivityViewModel.count.toString()
        btnCount.setOnClickListener {
            mainActivityViewModel.update()
            tvCount.text = mainActivityViewModel.count.toString()
        }
    }
}