package org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.model.pizzas;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramon.boza on 1/4/16.
 */
public class CheesePizza extends AbstractPizza {


    @Override
    public void addIngredients() {
        this.name = "Cheese";
        this.ingredients.addAll(Arrays.asList("Tomato","Cheese","4 cheeses"));
    }
}
