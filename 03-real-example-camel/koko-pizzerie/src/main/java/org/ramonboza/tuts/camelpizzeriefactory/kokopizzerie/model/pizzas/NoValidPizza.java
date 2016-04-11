package org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.model.pizzas;

/**
 * Created by ramon.boza on 6/4/16.
 */
public class NoValidPizza extends AbstractPizza {

    @Override
    public void addIngredients() {
        ingredients.add("none");
    }
}
