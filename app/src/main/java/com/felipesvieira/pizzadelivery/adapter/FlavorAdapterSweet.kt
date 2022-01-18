package com.felipesvieira.pizzadelivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.felipesvieira.pizzadelivery.R
import com.felipesvieira.pizzadelivery.data.Datasource.sweetPizzas


class FlavorAdapterSweet : RecyclerView.Adapter<FlavorAdapterSweet.FlavorViewHolder>() {

    class FlavorViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageItem: ImageView = view.findViewById(R.id.image_flavor)
        val nameItem: TextView = view.findViewById(R.id.text_name)
        val priceItem: TextView = view.findViewById(R.id.text_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlavorViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_flavor, parent, false)

        return FlavorViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: FlavorViewHolder, position: Int) {
        val item = sweetPizzas[position]

        holder.imageItem.setImageResource(item.flavorImage)
        holder.nameItem.text = item.flavorName
        holder.priceItem.text = "R$ " + item.flavorPrice.toString()
    }

    override fun getItemCount(): Int {
        return sweetPizzas.size
    }
}