package com.felipesvieira.pizzadelivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.felipesvieira.pizzadelivery.R
import com.felipesvieira.pizzadelivery.data.Datasource.sweetPizzas
import com.felipesvieira.pizzadelivery.viewmodels.OrderViewModel


class FlavorAdapterSweet(private val viewModel: OrderViewModel) : RecyclerView.Adapter<FlavorAdapterSweet.FlavorViewHolder>() {

    class FlavorViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageItem: ImageView = view.findViewById(R.id.image_flavor)
        val nameItem: TextView = view.findViewById(R.id.text_name)
        val priceItem: TextView = view.findViewById(R.id.text_price)
        val increaseButton: Button = view.findViewById(R.id.button_increase)
        val decreaseButton: Button = view.findViewById(R.id.button_decrease)
        val quantityItem: TextView = view.findViewById(R.id.text_quantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlavorViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_flavor, parent, false)

        return FlavorViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: FlavorViewHolder, position: Int) {
        val item = sweetPizzas[position]
        val quantity = viewModel.getQuantity(item.flavorName)

        holder.imageItem.setImageResource(item.flavorImage)
        holder.nameItem.text = item.flavorName
        holder.priceItem.text = "R$ " + item.flavorPrice.toString()

        if (quantity != 0) {
            holder.quantityItem.text = quantity.toString()
        } else {
            holder.quantityItem.text = ""
        }

        holder.increaseButton.setOnClickListener{
            holder.quantityItem.text = viewModel.increaseQuantity(item.flavorName, item.flavorPrice).toString()
        }

        holder.decreaseButton.setOnClickListener{
            val quantity = viewModel.decreaseQuantity(item.flavorName, item.flavorPrice)
            if (quantity != 0) {
                holder.quantityItem.text = quantity.toString()
            } else {
                holder.quantityItem.text = ""
            }

        }
    }

    override fun getItemCount(): Int {
        return sweetPizzas.size
    }
}