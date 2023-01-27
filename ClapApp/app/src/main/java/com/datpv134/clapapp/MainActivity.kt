package com.datpv134.clapapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.SeekBar
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var tvPlayed: TextView
    private lateinit var tvDue: TextView
    private lateinit var seekBar: SeekBar
    private lateinit var runnable: Runnable
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar = findViewById(R.id.sbPlaying)
        handler = Handler(Looper.getMainLooper())

        val fabPlay = findViewById<FloatingActionButton>(R.id.fabPlay)
        val fabPause = findViewById<FloatingActionButton>(R.id.fabPause)
        val fabStop = findViewById<FloatingActionButton>(R.id.fabStop)
        tvPlayed = findViewById(R.id.tvPlayed)
        tvDue = findViewById(R.id.tvDue)

        fabPlay.setOnClickListener {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.clapping)
                initializeSeekBar()
            }

            mediaPlayer?.start()
        }

        fabPause.setOnClickListener {
            mediaPlayer?.pause()
        }

        fabStop.setOnClickListener {
            if (mediaPlayer != null) {
                mediaPlayer?.stop()
                mediaPlayer?.reset()
                mediaPlayer?.release()
                mediaPlayer = null
                handler.removeCallbacks(runnable)
                seekBar.progress = 0
                tvPlayed.text = ""
                tvDue.text = ""
            }
        }
    }

    private fun initializeSeekBar() {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, process: Int, fromUser: Boolean) {
                if (fromUser) mediaPlayer?.seekTo(process)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        seekBar.max = mediaPlayer!!.duration
        runnable = Runnable {
            seekBar.progress = mediaPlayer!!.currentPosition

            val playedTime = mediaPlayer!!.currentPosition / 1000
            tvPlayed.text = "$playedTime sec"
            val duration = mediaPlayer!!.duration / 1000
            val dueTime = duration - playedTime
            tvDue.text = "$dueTime sec"

            handler.postDelayed(runnable, 1000)
        }

        handler.postDelayed(runnable, 1000)
    }
}