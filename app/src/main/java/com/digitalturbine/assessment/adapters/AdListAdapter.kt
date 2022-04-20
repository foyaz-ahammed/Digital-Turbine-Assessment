package com.digitalturbine.assessment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.digitalturbine.assessment.databinding.RowAdItemBinding
import com.digitalturbine.assessment.repository.entities.Response

/**
 * [ListAdapter] to show list of ads
 */
class AdListAdapter: ListAdapter<Response.Ad, AdListAdapter.ViewHolder>(DiffCallback) {
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

    class ViewHolder(private val binding: RowAdItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Response.Ad) {
            binding.productName.text = item.productName
        }
    }
}