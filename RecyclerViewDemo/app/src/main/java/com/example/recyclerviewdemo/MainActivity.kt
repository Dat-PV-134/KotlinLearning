package com.example.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val personList = listOf<Person>(
        Person("Dat", "16"),
        Person("Phong", "12"),
        Person("Ngo", "19"),
        Person("Kotlin", "100")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvItem = findViewById<RecyclerView>(R.id.rvItem)
        rvItem.setBackgroundColor(Color.GRAY)
        rvItem.layoutManager = LinearLayoutManager(this)
        rvItem.adapter = MyRecyclerViewAdapter(personList) { selectedItem: Person ->
            onClickItem(selectedItem)
        }
    }

    private fun onClickItem(person: Person) {
        Toast.makeText(this@MainActivity, "This is ${person.name}", Toast.LENGTH_SHORT).show()
    }
}