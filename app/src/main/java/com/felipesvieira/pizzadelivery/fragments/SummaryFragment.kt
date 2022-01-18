package com.felipesvieira.pizzadelivery.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.felipesvieira.pizzadelivery.databinding.FragmentSummaryBinding
import com.felipesvieira.pizzadelivery.viewmodels.OrderViewModel

class SummaryFragment : Fragment() {

    private lateinit var binding: FragmentSummaryBinding
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSummaryBinding.inflate(inflater, container, false)
        val selected = sharedViewModel.filterSelected()
        binding.apply {
            viewModel = sharedViewModel

        }

        return binding.root
    }
}