package org.ramonboza.tuts.camelpizzeriefactory.parangonpizza.model.pizzas;

import com.google.common.base.Preconditions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramon.boza on 1/4/16.
 */
public final class Pizza implements Serializable {

     private String name = "";

     private List<String> ingredients = new ArrayList<String>();

     private Pizza(final String name){
          this.name = name;
     }



     public static class PizzaBuilder {

          private Pizza pizza;

          public PizzaBuilder(final String name) {
               pizza = new Pizza(name);
          }

          public PizzaBuilder withIngredient(String ingredient){

               Preconditions.checkNotNull(ingredient);

               pizza.ingredients.add(ingredient);
               return this;
          }

          public Pizza build(){
               return pizza;
          }

     }

}
