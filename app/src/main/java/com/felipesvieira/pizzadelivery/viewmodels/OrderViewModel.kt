package com.felipesvieira.pizzadelivery.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.felipesvieira.pizzadelivery.data.Datasource

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
        val quantity = (itemCounter[name]?:0) + 1
        itemCounter[name] = quantity

        _orderPrice.value = (_orderPrice.value?:0.0).plus(flavorPrice)
        _orderPrice.value = String.format("%.2f", _orderPrice.value).toDouble()

        return (itemCounter[name]?:0)
    }

    fun decreaseQuantity(name: String, flavorPrice: Double): Int {
        var quantity = (itemCounter[name]?:0)

        if ((itemCounter[name]?:0) > 0) {
            quantity -= 1

            _orderPrice.value = (_orderPrice.value?:0.0).minus(flavorPrice)
            _orderPrice.value = String.format("%.2f", _orderPrice.value).toDouble()

        }
        itemCounter[name] = quantity
        return (itemCounter[name]?:0)
    }

    fun getPrice (name: String): Double {
        var price = 0.0

        Datasource.saltPizzas.forEach {
            if (it.flavorName == name) price = it.flavorPrice
        }

        Datasource.sweetPizzas.forEach {
            if (it.flavorName == name) price = it.flavorPrice
        }

        Datasource.drinks.forEach {
            if (it.flavorName == name) price = it.flavorPrice
        }

        return price
    }

    fun getSelected(): Map<String, Int> {
        return itemCounter.filter {it.value > 0}
    }

    fun resetOrder() {
        itemCounter.clear()
        _orderPrice.value = 0.0
    }
}