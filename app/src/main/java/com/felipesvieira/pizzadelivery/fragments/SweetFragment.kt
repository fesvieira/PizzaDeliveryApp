package com.felipesvieira.pizzadelivery.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.felipesvieira.pizzadelivery.adapter.SweetAdapter
import com.felipesvieira.pizzadelivery.databinding.FragmentSweetBinding
import com.felipesvieira.pizzadelivery.viewmodels.OrderViewModel

class SweetFragment : Fragment(){

    private lateinit var binding: FragmentSweetBinding
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSweetBinding.inflate(inflater, container, false)

        binding.apply {
            recyclerFlavors.adapter = SweetAdapter(sharedViewModel)

            buttonNext.setOnClickListener{
                val action = SweetFragmentDirections.actionSweetFragmentToDrinksFragment()
                findNavController().navigate(action)
            }
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
        }


        return binding.root
    }


}