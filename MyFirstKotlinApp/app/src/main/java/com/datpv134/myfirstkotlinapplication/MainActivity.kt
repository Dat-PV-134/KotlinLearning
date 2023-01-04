package com.datpv134.myfirstkotlinapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvHello = findViewById<TextView>(R.id.tvHello)
        val etName = findViewById<EditText>(R.id.etName)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnViewOffer = findViewById<Button>(R.id.btnOffer)
        var enteredName = ""

        btnSubmit.setOnClickListener {
            enteredName = etName.text.toString()

            if (enteredName == "") {
                btnViewOffer.visibility = INVISIBLE
                tvHello.text = ""
                Toast.makeText(
                    this@MainActivity,
                    "Please enter your name",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val message = "Welcome $enteredName"
                tvHello.text = message
                etName.text.clear()
                btnViewOffer.visibility = VISIBLE
            }
        }

        btnViewOffer.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user", enteredName)
            startActivity(intent)
        }
    }
}