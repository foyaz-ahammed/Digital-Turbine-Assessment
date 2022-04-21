package com.digitalturbine.assessment.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.digitalturbine.assessment.R
import com.digitalturbine.assessment.adapters.AdListAdapter
import com.digitalturbine.assessment.databinding.ActivityMainBinding
import com.digitalturbine.assessment.repository.entities.LoadResult
import com.digitalturbine.assessment.viewModels.AdListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Main activity to show list of ads
 * @see [R.layout.activity_main]
 */
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<AdListViewModel>()
    private val adapter = AdListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter

        viewModel.adList.observe(this) {
            adapter.submitList(it)
        }
        viewModel.loading.observe(this) {
            binding.progressBar.isVisible = it == LoadResult.LOADING
            binding.recyclerView.isVisible = it == LoadResult.SUCCESS
        }

        adapter.setItemClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        // Load date when the activity is first created
        if (savedInstanceState == null) {
            viewModel.loadData()
        }
    }
}