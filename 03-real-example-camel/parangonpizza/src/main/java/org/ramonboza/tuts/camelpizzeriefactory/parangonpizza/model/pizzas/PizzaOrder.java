package org.ramonboza.tuts.camelpizzeriefactory.parangonpizza.model.pizzas;

import java.io.Serializable;

/**
 * Created by ramon.boza on 11/4/16.
 */
public final class PizzaOrder implements Serializable{

    private final Pizza pizza;

    private final int price;

    PizzaOrder(final Pizza pizza, final int price){
        this.pizza = pizza;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Pizza getPizza() {
        return pizza;
    }


    public static class PizzaOrderBuilder {

        private Pizza pizza;

        private int price;

        public PizzaOrderBuilder(final Pizza pizza, final int price){
            this.pizza = pizza;
            this.price = price;
        }

        public PizzaOrder build(){
            return new PizzaOrder(pizza,price);
        }
    }
}


