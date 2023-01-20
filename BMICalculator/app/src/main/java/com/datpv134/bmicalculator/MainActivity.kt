package com.datpv134.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etWeight = findViewById<EditText>(R.id.etWeight)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            val weight = etWeight.text.toString()
            val height = etHeight.text.toString()

            if (validateInput(weight, height)) {
                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))
                val bmi2Digits = String.format("%.2f", bmi).replace(",", ".").toFloat()

                displayResult(bmi2Digits)
            }
        }
    }

    private fun validateInput(weight: String?, height: String?): Boolean {
         return when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty", Toast.LENGTH_SHORT).show()
                false
            }

            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty", Toast.LENGTH_SHORT).show()
                false
            }

            else -> {
                true
            }
        }
    }

    private fun displayResult(bmi: Float) {
        val tvIndex = findViewById<TextView>(R.id.tvIndex)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val tvInfo = findViewById<TextView>(R.id.tvInfo)

        tvIndex.text = bmi.toString()
        tvInfo.text = getString(R.string.normal)

        var result = ""
        var color = 0
        when {
            bmi < 18.50 -> {
                result = "Underweight"
                color = R.color.under_weight
            }

            bmi in 18.50..24.99 -> {
                result = "Healthy"
                color = R.color.normal
            }

            bmi in 25.00..29.99 -> {
                result = "Overweight"
                color = R.color.over_weight
            }

            bmi > 29.99 -> {
                result = "Obese"
                color = R.color.obese
            }
        }

        tvResult.setTextColor(ContextCompat.getColor(this, color))
        tvResult.text = result
    }
}