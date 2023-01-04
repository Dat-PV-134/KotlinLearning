package com.datpv134.myfirstkotlinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val offerName = intent.getStringExtra("user")
        val message = "$offerName, you have 1 month to free use this!"

        val tvOffer = findViewById<TextView>(R.id.tvOffer)
        tvOffer.text = message
    }
}