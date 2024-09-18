package com.example.sharedpreferenceshilt.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences,
): ViewModel(){
    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int> = _counter

    init {
        val currentCounter = sharedPreferences.getInt("counter_value", 0)
        _counter.value = currentCounter
    }

    fun increaseCounter() {
        val newCounter = (_counter.value ?: 0) + 1
        _counter.value = newCounter

        sharedPreferences.edit().putInt("counter_value", newCounter).apply()
    }
}