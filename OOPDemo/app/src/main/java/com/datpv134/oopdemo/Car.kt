package com.datpv134.oopdemo

import android.util.Log

open class Car {
    var maxSpeed = 30

    open fun start() {
        Log.i("MyTag", "Car is starting...")
        Log.i("MyTag", "Maximum speed is $maxSpeed")
    }
}