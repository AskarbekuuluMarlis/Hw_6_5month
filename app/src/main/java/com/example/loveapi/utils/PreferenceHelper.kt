package com.example.loveapi.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class PreferenceHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun onShowed() {
        sharedPreferences.edit().putBoolean(SHOWED, false).apply()
    }

    fun isShowed(): Boolean {
        return sharedPreferences.getBoolean(SHOWED, true)
    }

    companion object {
        const val SHOWED = "SHOWED"
    }
}