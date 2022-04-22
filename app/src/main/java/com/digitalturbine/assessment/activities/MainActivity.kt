package com.digitalturbine.assessment.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.digitalturbine.assessment.adapters.AdListAdapter
import com.digitalturbine.assessment.databinding.ActivityMainBinding
import com.digitalturbine.assessment.repository.entities.LoadResult
import com.digitalturbine.assessment.repository.entities.Response
import com.digitalturbine.assessment.viewModels.AdListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Main activity to show list of ads
 * @see [ActivityMainBinding]
 */
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<AdListViewModel>()
    private val adapter = AdListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter
        binding.btnRetry.setOnClickListener {
            viewModel.loadData()
        }

        viewModel.adList.observe(this) { it ->
            adapter.submitList(it.sortedWith( compareByDescending<Response.Ad> { it.numberOfDownloads }.thenByDescending { it.rating }) )
        }
        viewModel.loading.observe(this) {
            binding.progressBar.isVisible = it == LoadResult.LOADING
            binding.recyclerView.isVisible = it == LoadResult.SUCCESS
            binding.errorViews.isVisible = it == LoadResult.FAIL
        }

        adapter.setItemClickListener {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_AD_ITEM, it)
            }
            startActivity(intent)
        }

        // Load date when the activity is first created
        if (savedInstanceState == null) {
            viewModel.loadData()
        }
    }
}