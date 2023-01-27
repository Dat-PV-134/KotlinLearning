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
    private lateinit var seekBar: SeekBar
    private lateinit var runnable: Runnable
    private lateinit var handler: Handler
    private lateinit var tvPlayed: TextView
    private lateinit var tvDue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = Handler(Looper.getMainLooper())
        tvPlayed = findViewById<TextView>(R.id.tvPlayed)
        tvDue = findViewById<TextView>(R.id.tvDue)

        val fabPlay = findViewById<FloatingActionButton>(R.id.fabPlay)
        fabPlay.setOnClickListener {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.clapping)
                initializeSeekBar()
            }

            mediaPlayer?.start()
        }

        val fabPause = findViewById<FloatingActionButton>(R.id.fabPause)
        fabPause.setOnClickListener {
            mediaPlayer?.pause()
        }

        val fabStop = findViewById<FloatingActionButton>(R.id.fabStop)
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
        seekBar = findViewById(R.id.sbPlaying)
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
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