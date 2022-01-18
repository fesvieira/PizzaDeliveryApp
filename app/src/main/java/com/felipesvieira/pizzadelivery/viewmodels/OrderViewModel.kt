package com.felipesvieira.pizzadelivery.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel: ViewModel() {

    private val itemCounter = mutableMapOf<String, Int>()

    private val _orderPrice = MutableLiveData(0.00)
    val orderPrice: LiveData<Double> = _orderPrice


    fun getQuantity(name: String): Int? {
        val existInMap = itemCounter.containsKey(name)

        if (!existInMap) itemCounter[name] = 0

        return itemCounter[name]
    }

    fun increaseQuantity(name: String, flavorPrice: Double): Int {
        val quantity = itemCounter[name]!! + 1
        itemCounter[name] = quantity

        _orderPrice.value = _orderPrice.value!!.plus(flavorPrice)
        _orderPrice.value = String.format("%.2f", _orderPrice.value).toDouble()

        return itemCounter[name]!!
    }

    fun decreaseQuantity(name: String, flavorPrice: Double): Int {
        var quantity = itemCounter[name]!!

        if (itemCounter[name]!! > 0) {
            quantity -= 1

            _orderPrice.value = _orderPrice.value!!.minus(flavorPrice)
            _orderPrice.value = String.format("%.2f", _orderPrice.value).toDouble()

        }
        itemCounter[name] = quantity
        return itemCounter[name]!!
    }

    fun filterSelected(): Map<String, Int> {

        return itemCounter.filter { (key, value) -> value > 0 }
    }


}