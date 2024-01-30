package com.cloffygames.gpacalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        // SharedPreferences'a bağlan.
        val sharedPreferences = getSharedPreferences("com.cloffygames.gpacalculator", Context.MODE_PRIVATE)

        // SharedPreferences üzerinde düzenleme yapmak için bir editor oluştur.
        val editor = sharedPreferences.edit()
    }
}