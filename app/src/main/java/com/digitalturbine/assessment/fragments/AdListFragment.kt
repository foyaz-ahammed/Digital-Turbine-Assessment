package com.digitalturbine.assessment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.digitalturbine.assessment.databinding.FragmentAdListBinding

/**
 * Fragment for Advertise List Screen
 */
class AdListFragment: Fragment() {
    private lateinit var binding: FragmentAdListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdListBinding.inflate(layoutInflater)
        return binding.root
    }
}