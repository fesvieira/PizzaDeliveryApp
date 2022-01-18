package com.felipesvieira.pizzadelivery.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.felipesvieira.pizzadelivery.adapter.FlavorAdapterDrink
import com.felipesvieira.pizzadelivery.databinding.FragmentDrinksBinding

class DrinksFragment : Fragment(){

    private lateinit var binding: FragmentDrinksBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinksBinding.inflate(inflater, container, false)

        binding.recyclerFlavors.adapter = FlavorAdapterDrink()

        return binding.root
    }


}