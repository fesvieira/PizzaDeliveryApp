package com.felipesvieira.pizzadelivery.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.felipesvieira.pizzadelivery.adapter.FlavorAdapterSweet
import com.felipesvieira.pizzadelivery.databinding.FragmentSweetBinding

class SweetFragment : Fragment(){

    private lateinit var binding: FragmentSweetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSweetBinding.inflate(inflater, container, false)
        binding.recyclerFlavors.adapter = FlavorAdapterSweet()

        binding.buttonNext.setOnClickListener{
            val action = SweetFragmentDirections.actionSweetFragmentToDrinksFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }


}