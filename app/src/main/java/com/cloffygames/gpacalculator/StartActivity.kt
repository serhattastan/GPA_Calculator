package com.cloffygames.gpacalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cloffygames.gpacalculator.databinding.ActivityMainBinding
import com.cloffygames.gpacalculator.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SharedPreferences'a bağlan.
        val sharedPreferences = getSharedPreferences("com.cloffygames.gpacalculator", Context.MODE_PRIVATE)

        // SharedPreferences üzerinde düzenleme yapmak için bir editor oluştur.
        val editor = sharedPreferences.edit()
    }
}