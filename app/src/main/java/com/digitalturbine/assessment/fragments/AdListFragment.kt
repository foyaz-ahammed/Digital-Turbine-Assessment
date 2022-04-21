package com.digitalturbine.assessment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.digitalturbine.assessment.adapters.AdListAdapter
import com.digitalturbine.assessment.databinding.FragmentAdListBinding
import com.digitalturbine.assessment.repository.entities.LoadResult
import com.digitalturbine.assessment.viewModels.AdListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment for Advertise List Screen
 */
class AdListFragment: Fragment() {
    private lateinit var binding: FragmentAdListBinding
    private val viewModel by viewModel<AdListViewModel>()
    private val adapter = AdListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter

        viewModel.adList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it == LoadResult.LOADING
            binding.recyclerView.isVisible = it == LoadResult.SUCCESS
        }

        viewModel.loadData()
    }
}