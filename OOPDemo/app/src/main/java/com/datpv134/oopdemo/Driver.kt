package com.datpv134.oopdemo

import android.util.Log

class Driver(var name : String, credit : Int) {
    // var driverName = ""
    // lateinit var driverName : String
    // var driverName = name

    private var totalCredit = 50
    private var car = Car()

    init {
        // driverName = name
        car.maxSpeed = 150
        totalCredit += credit
    }

    fun showDetails() {
        // Log.i("MyTag", "name of the driver is $driverName")
        Log.i("MyTag", "name of the driver is $name with $totalCredit credits")
    }
}