package com.felipesvieira.pizzadelivery.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.ceil
import kotlin.math.round

class OrderViewModel: ViewModel() {

    private var itemCounter = mutableMapOf<String, Int>()

    private var _orderPrice = MutableLiveData(0.00)
    val orderPrice: LiveData<Double> = _orderPrice


    fun getQuantity(name: String): Int? {
        val existInMap = itemCounter.containsKey(name)

        if (existInMap) {
            return itemCounter[name]
        } else {
            itemCounter[name] = 0
            return itemCounter[name]
        }
    }

    fun increaseQuantity(name: String, flavorPrice: Double): Int {
        var quantity = itemCounter[name]!! + 1
        itemCounter[name] = quantity

        _orderPrice.value = _orderPrice.value!!.plus(flavorPrice)
        _orderPrice.value = String.format("%.2f", _orderPrice.value).toDouble()
        return itemCounter[name]!!
    }

    fun decreaseQuantity(name: String, flavorPrice: Double): Int {
        var quantity = itemCounter[name]!!
        if (itemCounter[name]!! > 0) {
            quantity = itemCounter[name]!! - 1
            _orderPrice.value = _orderPrice.value!!.minus(flavorPrice)
            _orderPrice.value = String.format("%.2f", _orderPrice.value).toDouble()
            if (_orderPrice.value!! < 1) {
                _orderPrice.value = 0.0
            }
        }
        itemCounter[name] = quantity
        return itemCounter[name]!!
    }


}