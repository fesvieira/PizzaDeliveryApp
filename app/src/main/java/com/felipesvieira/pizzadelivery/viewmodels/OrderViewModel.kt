package com.felipesvieira.pizzadelivery.viewmodels

import androidx.lifecycle.ViewModel

class OrderViewModel: ViewModel() {

    private var itemCounter = mutableMapOf<String, Int>()

    fun getQuantity(name: String): Int? {
        val existInMap = itemCounter.containsKey(name)

        if (existInMap) {
            return itemCounter[name]
        } else {
            itemCounter[name] = 0
            return itemCounter[name]
        }
    }

    fun increaseQuantity(name: String): Int {
        var quantity = itemCounter[name]!! + 1
        itemCounter[name] = quantity
        return itemCounter[name]!!
    }

    fun decreaseQuantity(name: String): Int {
        var quantity = itemCounter[name]!!
        if (itemCounter[name]!! > 0) {
            quantity = itemCounter[name]!! - 1
        }
        itemCounter[name] = quantity
        return itemCounter[name]!!
    }

}