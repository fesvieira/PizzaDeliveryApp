package com.felipesvieira.pizzadelivery.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.felipesvieira.pizzadelivery.adapter.SaltAdapter
import com.felipesvieira.pizzadelivery.databinding.FragmentSaltBinding
import com.felipesvieira.pizzadelivery.viewmodels.OrderViewModel

class SaltFragment : Fragment(){

    private lateinit var binding: FragmentSaltBinding
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSaltBinding.inflate(inflater, container, false)

        binding.apply {
            recyclerFlavors.adapter = SaltAdapter(sharedViewModel)
            buttonNext.setOnClickListener {
                val action = SaltFragmentDirections.actionSaltFragmentToSweetFragment()
                findNavController().navigate(action)
            }
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
        }

        return binding.root

    }


}