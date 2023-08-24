package com.example.viewmodelandlivedata2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelandlivedata2.databinding.ActivityCountBinding

class CountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCountBinding
    private lateinit var viewModel: CountActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_count)

        viewModel = ViewModelProvider(this)[CountActivityViewModel::class.java]
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this
    }
}