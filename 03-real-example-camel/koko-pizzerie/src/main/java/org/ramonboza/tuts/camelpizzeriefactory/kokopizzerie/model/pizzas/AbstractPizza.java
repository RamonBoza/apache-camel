package org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.model.pizzas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramon.boza on 1/4/16.
 */
public abstract class AbstractPizza implements Pizza {

    String name = "none";

    private boolean cooked = false;

    ArrayList<String> ingredients = new ArrayList<String>();

    @Override
    public void bake() {
        cooked = true;
    }
}
