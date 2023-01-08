package com.datpv134.oopdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val car = Car()
//        car.maxSpeed = 150
//        car.start()

//        val driver = Driver("Dat dep trai", 50)
//        driver.showDetails()

        var myCar = MyCar()
        myCar.maxSpeed = 900
        myCar.start()
    }
}