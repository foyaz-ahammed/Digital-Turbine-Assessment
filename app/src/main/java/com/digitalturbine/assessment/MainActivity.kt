package com.digitalturbine.assessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.digitalturbine.assessment.databinding.ActivityMainBinding

/**
 * Main Activity
 * @see [R.layout.activity_main]
 */
class MainActivity : AppCompatActivity() {
    // Binding variable
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}