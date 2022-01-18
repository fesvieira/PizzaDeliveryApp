package com.felipesvieira.pizzadelivery.data

import com.felipesvieira.pizzadelivery.R
import com.felipesvieira.pizzadelivery.model.Flavor

object Datasource {

    val saltPizzas = listOf(
        Flavor(R.drawable.pizza_alho, "Alho", 24.99),
        Flavor(R.drawable.pizza_bacon, "Bacon", 27.99),
        Flavor(R.drawable.pizza_calabresa, "Calabresa", 25.99,),
        Flavor(R.drawable.pizza_frango, "Chicken", 23.99),
        Flavor(R.drawable.pizza_portuguesa, "Portuguese", 29.99),
        Flavor(R.drawable.pizza_presunto, "Presunto", 21.35),
        Flavor(R.drawable.pizza_queijo, "Cheese", 21.99),
        Flavor(R.drawable.pizza_rucula, "Rucula", 23.99),
        Flavor(R.drawable.pizza_strogonoff, "Stroganoff", 32.99)
    )

    val sweetPizzas = listOf(
        Flavor(R.drawable.pizza_abacaxi,"Pineapple", 22.99),
        Flavor(R.drawable.pizza_chocolate, "Chocolate", 27.99),
        Flavor(R.drawable.pizza_chocolatebranco, "White Chocolate", 27.99),
        Flavor(R.drawable.pizza_chocolateduplo, "Dual Chocolate", 27.99),
        Flavor(R.drawable.pizza_confeti, "Confetti", 32.99,),
        Flavor(R.drawable.pizza_limao, "Lemon", 30.99),
        Flavor(R.drawable.pizza_morango, "Strawberry", 40.99),
        Flavor(R.drawable.pizza_sorvete, "Ice cream", 39.99)
    )

    val drinks = listOf(
        Flavor(R.drawable.drink_coca, "Coca-Cola", 15.99),
        Flavor(R.drawable.drink_guarana, "Other refrigerant", 4.99),
        Flavor(R.drawable.drink_juice, "Juice",8.99)
    )

}