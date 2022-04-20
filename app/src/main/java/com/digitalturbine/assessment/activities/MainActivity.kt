package com.digitalturbine.assessment.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.digitalturbine.assessment.R
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