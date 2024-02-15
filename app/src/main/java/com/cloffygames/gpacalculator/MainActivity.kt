package com.cloffygames.gpacalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.cloffygames.gpacalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // NavHostFragment'i bul
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        // BottomNavigationView'i NavController ile bağla
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navHostFragment.navController)

        // Navigasyon kontrolcüsüne bir hedef değişikliği dinleyicisi ekleme
        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            // Eğer hedefin değiştiği durumdaysak ve hedef fragmentlar 'addDepartmentFragment' veya 'semesterFragment' ise,
            if (destination.id == R.id.addDepartmentFragment || destination.id == R.id.semesterFragment || destination.id == R.id.departmentFragment) {
                // BottomNavigationView'ı gizle
                binding.bottomNavigationView.visibility = View.GONE
            } else {
                // Diğer durumlarda BottomNavigationView'ı görünür yap
                binding.bottomNavigationView.visibility = View.VISIBLE
            }
        }

    }
}