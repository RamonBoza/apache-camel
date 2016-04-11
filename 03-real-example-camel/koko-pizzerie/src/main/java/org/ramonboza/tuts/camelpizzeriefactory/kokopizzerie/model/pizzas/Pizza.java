package org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.model.pizzas;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramon.boza on 1/4/16.
 */
public interface Pizza extends Serializable {

     void addIngredients();

     void bake();
}
