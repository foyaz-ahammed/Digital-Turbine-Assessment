package com.digitalturbine.assessment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.digitalturbine.assessment.databinding.RowAdItemBinding
import com.digitalturbine.assessment.repository.entities.Response

/**
 * [ListAdapter] to show list of ads
 */
class AdListAdapter(private var listener: ((item: Response.Ad) -> Unit)? = null):
    ListAdapter<Response.Ad, AdListAdapter.ViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowAdItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    object DiffCallback: DiffUtil.ItemCallback<Response.Ad>() {
        override fun areItemsTheSame(oldItem: Response.Ad, newItem: Response.Ad): Boolean =
            oldItem.appId == newItem.appId

        override fun areContentsTheSame(oldItem: Response.Ad, newItem: Response.Ad): Boolean =
            oldItem != newItem
    }

    fun setItemClickListener(listener: ((item: Response.Ad) -> Unit)?) {
        this.listener = listener
    }

    /**
     * [ViewHolder] used to show an item
     */
    inner class ViewHolder(private val binding: RowAdItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Response.Ad) {
            binding.productName.text = item.productName
            binding.ratingBar.rating = item.rating
            binding.ratingNum.text = item.rating.toString()
            binding.downloads.text = item.numberOfDownloads

            Glide.with(binding.root.context.applicationContext)
                .load(item.productThumbnail)
                .fitCenter()
                .into(binding.productThumbnail)

            binding.root.setOnClickListener {
                listener?.invoke(item)
            }
        }
    }
}