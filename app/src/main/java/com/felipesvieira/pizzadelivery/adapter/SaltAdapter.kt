package com.felipesvieira.pizzadelivery.adapter

import android.annotation.SuppressLint
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.felipesvieira.pizzadelivery.R
import com.felipesvieira.pizzadelivery.data.Datasource.saltPizzas
import com.felipesvieira.pizzadelivery.databinding.ItemFlavorBinding
import com.felipesvieira.pizzadelivery.viewmodels.OrderViewModel


class SaltAdapter(private val viewModel: OrderViewModel) : RecyclerView.Adapter<SaltAdapter.FlavorViewHolder>() {

    private lateinit var binding: ItemFlavorBinding

    class FlavorViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val binding = ItemFlavorBinding.bind(view)
        val textQuantity = binding.textQuantity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlavorViewHolder {

        binding = ItemFlavorBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return FlavorViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: FlavorViewHolder, position: Int) {

        val item = saltPizzas[position]
        val quantity = viewModel.getQuantity(item.flavorName)

        holder.textQuantity.text =
            if (quantity != 0) quantity.toString()
            else ""

        binding.apply {

            imageFlavor.setImageResource(item.flavorImage)
            textName.text = item.flavorName
            textPrice.text = "$ ${item.flavorPrice}"

            buttonIncrease.setOnClickListener {
                holder.textQuantity.text =
                    viewModel.increaseQuantity(item.flavorName, item.flavorPrice).toString()
            }

            buttonDecrease.setOnClickListener {
                val newQuantity = viewModel.decreaseQuantity(item.flavorName, item.flavorPrice)
                holder.textQuantity.text =
                    if (newQuantity != 0) newQuantity.toString()
                    else ""
            }
        }
    }

    override fun getItemCount(): Int { return saltPizzas.size }
}
