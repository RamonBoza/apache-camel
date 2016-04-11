package org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.factory;

import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.model.pizzas.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by ramon.boza on 1/4/16.
 */

@Component
public class PizzaFactory {

	public static Optional<Pizza> createPizza(PizzaType type) {
		Pizza pizza = null;
		switch (type) {
			case BARBECUE :
				pizza = new BarbecuePizza();
				break;
			case CARBONARA :
				pizza = new CarbonaraPizza();
				break;
			case CHEESE :
				pizza = new CheesePizza();
				break;
			default :
				break;
		}
        return Optional.of(pizza);
    }
}
