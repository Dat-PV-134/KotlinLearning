package com.example.videoviewdemo

import android.net.Uri.parse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val mediaController = MediaController(this)

        mediaController.setAnchorView(videoView)
        val videoUri = parse("android.resource://" + packageName + "/" + R.raw.muhamad)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(videoUri)
        videoView.requestFocus()
        videoView.start()
    }
}