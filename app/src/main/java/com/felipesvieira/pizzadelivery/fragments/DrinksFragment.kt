package com.felipesvieira.pizzadelivery.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.felipesvieira.pizzadelivery.adapter.FlavorAdapterDrink
import com.felipesvieira.pizzadelivery.databinding.FragmentDrinksBinding
import com.felipesvieira.pizzadelivery.viewmodels.OrderViewModel

class DrinksFragment : Fragment(){

    private lateinit var binding: FragmentDrinksBinding
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinksBinding.inflate(inflater, container, false)

        binding.apply {
            recyclerFlavors.adapter = FlavorAdapterDrink(sharedViewModel)
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
        }

        return binding.root
    }


}