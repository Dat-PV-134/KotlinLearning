package com.datpv134.myfirstkotlinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.i("MTag", "Second Activity : onCreate")

        val offerName = intent.getStringExtra("user")
        val message = "$offerName, you have 1 month to free use this!"

        val tvOffer = findViewById<TextView>(R.id.tvOffer)
        tvOffer.text = message
    }

    override fun onStart() {
        super.onStart()
        Log.i("MTag", "Second Activity : onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MTag", "Second Activity : onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MTag", "Second Activity : onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MTag", "Second Activity : onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MTag", "Second Activity : onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MTag", "Second Activity : onRestart")
    }
}