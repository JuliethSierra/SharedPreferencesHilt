package com.example.sharedpreferenceshilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.sharedpreferenceshilt.databinding.ActivityMainBinding
import com.example.sharedpreferenceshilt.viewmodel.CounterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeCounter()
    }

    override fun onResume() {
        super.onResume()
        counterViewModel.increaseCounter()
    }

    private fun observeCounter() {
        counterViewModel.counter.observe(this) { newValue ->
            binding.tvCount.text = "Contador: $newValue"
        }
    }
}
