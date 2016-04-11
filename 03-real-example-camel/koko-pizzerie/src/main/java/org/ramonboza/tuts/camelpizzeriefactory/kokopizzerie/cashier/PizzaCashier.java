package org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.cashier;

import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.model.pizzas.Pizza;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.model.pizzas.PizzaType;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.store.PizzaStore;
import org.ramonboza.tuts.camelpizzeriefactory.kokopizzerie.system.PizzaSystem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramon.boza on 4/4/16.
 */
public class PizzaCashier implements Runnable {

    private final static Logger LOGGER = Logger.getLogger(PizzaCashier.class.getName());

    private PizzaStore pizzaStore;

    private PizzaSystem pizzaSystem;

    private List<PizzaType> pizzaTypes = null;

    private Random timeRandomizer = new Random();

    public PizzaCashier(final PizzaStore pizzaStore, PizzaSystem pizzaSystem) {
        this.pizzaStore = pizzaStore;
        this.pizzaSystem = pizzaSystem;
        pizzaTypes = Arrays.asList(PizzaType.values());
        timeRandomizer.setSeed(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while (true) {
            Collections.shuffle(pizzaTypes);
            pizzaSystem.register(pizzaStore.orderPizza(pizzaTypes.get(0)));
            int sleepTime = 1000 + timeRandomizer.nextInt(5000);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE,"This Cashier got to sleep");
            }
        }
    }
}
