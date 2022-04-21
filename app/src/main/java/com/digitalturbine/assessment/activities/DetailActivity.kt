package com.digitalturbine.assessment.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.digitalturbine.assessment.databinding.ActivityDetailBinding

/**
 * Activity used to to show detail screen
 */
class DetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}