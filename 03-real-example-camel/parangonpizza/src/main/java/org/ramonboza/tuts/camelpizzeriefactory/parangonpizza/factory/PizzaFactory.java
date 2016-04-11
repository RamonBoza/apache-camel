package org.ramonboza.tuts.camelpizzeriefactory.parangonpizza.factory;

import org.ramonboza.tuts.camelpizzeriefactory.parangonpizza.model.pizzas.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by ramon.boza on 1/4/16.
 */

@Component
public class PizzaFactory {

	public static Pizza createPizza(PizzaType type) {
		Pizza pizza = null;
		switch (type) {
			case BARBECUE :
				pizza = new Pizza.PizzaBuilder(type.name()).withIngredient("Barbecue").withIngredient("Bacon").build();
				break;
			case CARBONARA :
				pizza = new Pizza.PizzaBuilder(type.name()).withIngredient("Carbonara").withIngredient("Bacon").build();
				break;
			case CHEESE :
				pizza = new Pizza.PizzaBuilder(type.name()).withIngredient("Tomato").withIngredient("Cheese").build();
				break;
			default :
				break;
		}
        return pizza;
    }
}
