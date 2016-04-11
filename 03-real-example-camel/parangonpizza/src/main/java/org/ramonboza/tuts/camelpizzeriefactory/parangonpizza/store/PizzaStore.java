package org.ramonboza.tuts.camelpizzeriefactory.parangonpizza.store;


import org.ramonboza.tuts.camelpizzeriefactory.parangonpizza.factory.PizzaFactory;
import org.ramonboza.tuts.camelpizzeriefactory.parangonpizza.model.pizzas.Pizza;
import org.ramonboza.tuts.camelpizzeriefactory.parangonpizza.model.pizzas.PizzaType;

import java.util.Optional;

/**
 * Created by ramon.boza on 1/4/16.
 */
public class PizzaStore {

	private final PizzaFactory pizzaFactory;

	public PizzaStore(final PizzaFactory pizzaFactory) {
		this.pizzaFactory = pizzaFactory;
	}

	public Pizza orderPizza(PizzaType pizzaType) {
		Pizza pizza = pizzaFactory.createPizza(pizzaType);
		return pizza;
	}
}
