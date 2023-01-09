package com.datpv134.oopdemo

import android.util.Log

class MyCar : Car(), CarController {
    override fun start() {
        super.start()
        Log.i("MyTag", "This is my car starting... It's brand is ${getBrand()}")
    }

    override fun increaseSpeed() {

    }

    override fun decreaseSpeed() {

    }
}