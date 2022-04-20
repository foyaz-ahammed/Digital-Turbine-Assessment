package com.digitalturbine.assessment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.digitalturbine.assessment.databinding.FragmentAdListBinding
import com.digitalturbine.assessment.viewModels.AdListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment for Advertise List Screen
 */
class AdListFragment: Fragment() {
    private lateinit var binding: FragmentAdListBinding
    private val viewModel by viewModel<AdListViewModel>()

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

        viewModel.adList.observe(viewLifecycleOwner) {
        }
        viewModel.loading.observe(viewLifecycleOwner) {
        }

        viewModel.loadData()
    }
}