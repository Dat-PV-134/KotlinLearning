package com.datpv134.sharepreferencesdemo

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var etName:EditText
    private lateinit var etAge:EditText
    private lateinit var sf:SharedPreferences
    private lateinit var editor:SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)

        sf = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sf.edit()
    }

    override fun onPause() {
        super.onPause()
        val name = etName.text.toString()
        val age = etAge.text.toString().toInt()

        editor.apply {
            putString("sf_name", name)
            putInt("sf_age", age)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val name = sf.getString("sf_name", null)
        val age = sf.getInt("sf_age", 0)

        etName.setText(name)
        if (age != 0) etAge.setText(age.toString())
    }
}