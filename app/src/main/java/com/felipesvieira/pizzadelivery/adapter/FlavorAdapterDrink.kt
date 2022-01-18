package com.felipesvieira.pizzadelivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.felipesvieira.pizzadelivery.R
import com.felipesvieira.pizzadelivery.data.Datasource.drinks


class FlavorAdapterDrink : RecyclerView.Adapter<FlavorAdapterDrink.FlavorViewHolder>() {

    class FlavorViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageItem: ImageView = view.findViewById(R.id.image_flavor)
        val nameItem: TextView = view.findViewById(R.id.text_name)
        val priceItem: TextView = view.findViewById(R.id.text_price)
        val quantity: TextView = view.findViewById(R.id.text_quantity)
        val buttonIncrease: Button = view.findViewById(R.id.button_increase)
        val buttonDecrease: Button = view.findViewById(R.id.button_decrease)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlavorViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_flavor, parent, false)

        return FlavorViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: FlavorViewHolder, position: Int) {
        val item = drinks[position]

        holder.imageItem.setImageResource(item.flavorImage)
        holder.nameItem.text = item.flavorName
        holder.priceItem.text = "R$ " + item.flavorPrice.toString()

        holder.buttonIncrease.setOnClickListener{
            if (holder.quantity.text == "") {
                holder.quantity.text = "1"
            } else {
                holder.quantity.text = (holder.quantity.text.toString().toInt() + 1).toString()
            }

        }
    }

    override fun getItemCount(): Int {
        return drinks.size
    }
}