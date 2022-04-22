package com.digitalturbine.assessment.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.digitalturbine.assessment.databinding.ActivityDetailBinding
import com.digitalturbine.assessment.repository.entities.Response
import com.digitalturbine.assessment.viewModels.AdDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Activity used to to show detail screen
 * @see [ActivityDetailBinding]
 */
class DetailActivity: AppCompatActivity() {
    companion object {
        const val EXTRA_AD_ITEM = "extra_ad_item"
    }

    private lateinit var binding: ActivityDetailBinding
    private val viewModel by viewModel<AdDetailViewModel>()
    private var toast: Toast ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent?.getSerializableExtra(EXTRA_AD_ITEM)?.let {
            if (it is Response.Ad) {
                viewModel.updateData(it)
            }
        }

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.liveData.observe(this) {
            updateViews(it)
        }
    }

    private fun updateViews(item: Response.Ad) {
        item.let {
            binding.productName.text = it.productName
            binding.category.text = it.categoryName
            binding.ratingBar.rating = it.rating
            binding.ratingCount.text = it.numberOfRatings
            binding.description.text = it.productDescription
            binding.btnAction.text = it.callToAction
            binding.downloadCount.text = it.numberOfDownloads
            binding.requiresAndroid.text = it.minOSVersion?.plus(" and up") ?: "All"

            Glide.with(binding.root.context.applicationContext)
                .load(it.productThumbnail)
                .fitCenter()
                .into(binding.image)

            binding.btnAction.setOnClickListener { _ ->
                toast?.cancel()
                toast = Toast.makeText(
                    this,
                    it.productName + " (" + it.appId + ") " + "will be installed on your device soon",
                    Toast.LENGTH_SHORT).apply {
                    show()
                }
            }
        }
    }
}