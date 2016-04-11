package org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.store;

import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.factory.PizzaFactory;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.model.pizzas.NoValidPizza;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.model.pizzas.Pizza;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.model.pizzas.PizzaType;

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
		Optional<Pizza> opPizza = pizzaFactory.createPizza(pizzaType);
		Pizza pizza = opPizza.orElse(new NoValidPizza());
		pizza.addIngredients();
		pizza.bake();
		return pizza;
	}
}
