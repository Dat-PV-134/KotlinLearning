package com.datpv134.oopdemo

import android.util.Log

class MyCar : Car() {
    override fun start() {
        super.start()
        Log.i("MyTag", "This is my car starting...")
    }
}