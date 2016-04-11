package org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.model.pizzas;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramon.boza on 1/4/16.
 */
public class CarbonaraPizza extends AbstractPizza {


    @Override
    public void addIngredients() {
        this.name = "Carbonara";
        this.ingredients.addAll(Arrays.asList("Cream","Cheese","Bacon","Egg"));
    }

}
