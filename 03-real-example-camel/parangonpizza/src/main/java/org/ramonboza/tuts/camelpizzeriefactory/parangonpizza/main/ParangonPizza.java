package org.ramonboza.tuts.camelpizzeriefactory.parangonpizza.main;

import org.ramonboza.tuts.camelpizzeriefactory.parangonpizza.cashier.PizzaCashier;
import org.ramonboza.tuts.camelpizzeriefactory.parangonpizza.config.ParangonPizzaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramon.boza on 4/4/16.
 */
public class ParangonPizza {

	private final static Logger LOGGER = Logger.getLogger(ParangonPizza.class.getName());

	private static final int NUMBER_OF_CASHIERS_AVAILABLE = 4;

	public static void main(final String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(ParangonPizzaConfig.class);

		ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_CASHIERS_AVAILABLE);
		for (int i = 0; i < NUMBER_OF_CASHIERS_AVAILABLE; i++) {
			executor.execute(ctx.getBean(PizzaCashier.class));
		}

		try {
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			LOGGER.log(Level.SEVERE, "System cannot be shutdown");
		} finally {
			if (!executor.isTerminated()) {
				executor.shutdownNow();
			}
		}
	}
}
