package org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.model.pizzas;

import org.apache.commons.lang.SerializationUtils;
import org.junit.Test;

/**
 * Created by ramon.boza on 8/4/16.
 */
public class BarbecuePizzaTest {

    @Test
    public void testingBarbecuePizzaClassIsSerializable() {
        BarbecuePizza barbecuePizza = (BarbecuePizza)SerializationUtils.clone(new BarbecuePizza());
    }

}