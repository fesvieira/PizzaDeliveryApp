package com.felipesvieira.pizzadelivery.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.felipesvieira.pizzadelivery.MainActivity
import com.felipesvieira.pizzadelivery.databinding.FragmentSummaryBinding
import com.felipesvieira.pizzadelivery.viewmodels.OrderViewModel

class SummaryFragment : Fragment() {

    private lateinit var binding: FragmentSummaryBinding
    private val sharedViewModel: OrderViewModel by activityViewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSummaryBinding.inflate(inflater, container, false)
        val selected = sharedViewModel.getSelected()

        binding.apply {
            viewModel = sharedViewModel
            textNames.text = ""

            selected.forEach{
                textNames.text = textNames.text.toString() + "\n\n" + it.key
                textQuantities.text = textQuantities.text.toString() + "\n\n" + it.value
                val sumPrice = sharedViewModel.getPrice(it.key) * it.value
                textPrices.text = textPrices.text.toString() + "\n\n" + sumPrice
            }

            buttonReset.setOnClickListener{
                sharedViewModel.resetOrder()
                val action = SummaryFragmentDirections.actionSummaryFragmentToHomeFragment()

                findNavController().navigate(action)
            }

            buttonSend.setOnClickListener{
                Toast.makeText(activity,"The order will be prepared!!!",Toast.LENGTH_LONG)
                    .show()
            }

        }

        return binding.root
    }
}